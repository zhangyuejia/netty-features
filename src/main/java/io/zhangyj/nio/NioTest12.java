package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest12 {

    public static void main(String[] args) throws IOException {
        // 打开一个选择器
        Selector selector = Selector.open();
        // 定义端口
        int[] ports = {5000, 5001, 5002, 5003};
        for (int port : ports) {
            // 打开服务器通道，用于端口监听
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 配置成异步
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            // 注册到选择器，对接收连接事件感兴趣
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("绑定到端口：" + port);
        }
        //noinspection InfiniteLoopStatement
        while (true){
            // 阻塞方法，等待通道机型IO操作，返回键的个数
            int select = selector.select();
            if(select <= 0){
                continue;
            }
            // 只获取感兴趣的key，第一次只有连接事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){
                    // 获取对应端口的服务监听通道
                    ServerSocketChannel sSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    // 获取客户端通道
                    SocketChannel socketChannel = sSocketChannel.accept();
                    // 配置成异步
                    socketChannel.configureBlocking(false);
                    // 注册客户端通道的读方法（客户端通道可读，即通道写入数据）
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    log.info("客户端通道注册：{}", socketChannel);
                }else if(selectionKey.isReadable()){
                    // 在接收到客户端通道，已经注册了读取客户端通道方法
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    int dataLength = 0;
                    while (true){
                        int read = socketChannel.read(byteBuffer);
                        if(read <=0){
                            break;
                        }
                        dataLength += read;
                    }
                    log.info("读取数据长度：{}", dataLength);
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    byteBuffer.clear();
                }
                // 处理完成，必须对该Selection进行删除，不然会出现问题
                iterator.remove();
            }
        }
    }
}
