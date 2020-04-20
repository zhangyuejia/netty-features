package io.zhangyj.nio;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest13 {
    public static void main(String[] args) throws Exception{
        Map<SocketChannel, ByteBuffer> socketData = Maps.newHashMap();
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8899));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //noinspection InfiniteLoopStatement
        while (true){
            int select = selector.select();
            if(select <= 0){
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){
                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ );
                    socketData.put(socketChannel, ByteBuffer.allocate(512));
                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = socketData.get(socketChannel);
                    while (true){
                        int read = socketChannel.read(byteBuffer);
                        if(read <= 0){
                            break;
                        }
                        if(!checkReadOver(byteBuffer)){
                            return;
                        }
                        // 发送到别的channel
                        for (SocketChannel channel : socketData.keySet()) {
                            if(channel == socketChannel){
                                ByteBuffer encode = CharsetUtil.UTF_8.encode("me:");
                                channel.write(encode);
                            }
                            byteBuffer.flip();
                            channel.write(byteBuffer);
                        }
                        byteBuffer.clear();
                    }

                }
                iterator.remove();
            }
        }
    }

    /**
     * 检查是否读取完毕（按回车或者）
     * @param byteBuffer byteBuffer
     * @return 是否时回车
     */
    private static boolean checkReadOver(ByteBuffer byteBuffer) {
        // 缓冲区满了
        return byteBuffer.position() == byteBuffer.limit() || checkEnterPress(byteBuffer);
    }

    private static boolean checkEnterPress(ByteBuffer byteBuffer) {
        if(byteBuffer.position() < 2){
            return false;
        }
        byte b = byteBuffer.get(byteBuffer.position() - 1);
        byte b1 = byteBuffer.get(byteBuffer.position() - 2);
        return b == 10 && b1 == 13;
    }
}
