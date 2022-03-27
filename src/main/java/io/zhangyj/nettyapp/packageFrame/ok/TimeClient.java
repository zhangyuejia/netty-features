package io.zhangyj.nettyapp.packageFrame.ok;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TimeClient {

    public void connect(int port, String host) throws Exception {
        // 配置客户端NIO线程组
        //首先创建客户端处理I/O读写的NioEventLoop Group线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //继续创建客户端辅助启动类Bootstrap，随后需要对其进行配置。
            //与服务端不同的是，它的Channel需要设置为NioSocketChannel
            //然后为其添加handler，此处为了简单直接创建匿名内部类，实现initChannel方法，
            //其作用是当创建NioSocketChannel成功之后，
            //在初始化它的时候将它的ChannelHandler设置到ChannelPipeline中，用于处理网络I/O事件。
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            final ChannelPipeline pipeline = channel.pipeline();
                            // 解决粘包问题关键
                            // LineBasedFrameDecoder的工作原理是它依次遍历ByteBuf中的可读字节，判断看是否有“\n”或者“\r\n”，
                            // 如果有，就以此位置为结束位置，从可读索引到结束位置区间的字节就组成了一行。
                            // 它是以换行符为结束标志的解码器，支持携带结束符或者不携带结束符两种解码方式，同时支持配置单行的最大长度。
                            // 如果连续读取到最大长度后仍然没有发现换行符，就会抛出异常，同时忽略掉之前读到的异常码流。
                            //
                            pipeline.addLast(new LineBasedFrameDecoder(1024));
                            //StringDecoder的功能非常简单，就是将接收到的对象转换成字符串，然后继续调用后面的handler。LineBasedFrameDecoder + StringDecoder组合就是按行切换的文本解码器，它被设计用来支持TCP的粘包和拆包。
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new TimeClientHandler());
                        }
                    });

            // 发起异步连接操作
            //客户端启动辅助类设置完成之后，调用connect方法发起异步连接，
            //然后调用同步方法等待连接成功。
            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链路关闭
            //当客户端连接关闭之后，客户端主函数退出.
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            //在退出之前，释放NIO线程组的资源。
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
//        final ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 20 * 10000; i++) {
//            executorService.execute(() -> {
//                try {
//                    new TimeClient().connect(8080, "127.0.0.1");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        }

        new TimeClient().connect(8080, "127.0.0.1");
        // 发生了粘包，打印如下
        // Now is : BAD ORDER
        //BAD ORDER
        // ; the counter is : 1

    }
}

