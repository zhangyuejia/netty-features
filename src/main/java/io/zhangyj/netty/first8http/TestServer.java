package io.zhangyj.netty.first8http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Hello World Http Server
 * @author ZHANG-YJ
 */
public class TestServer {

    public static void main(String[] args) throws Exception{
        // boss线程组，用于接收连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // worker线程组，用于处理连接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            // 服务端启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerChannelInitializer());

            ChannelFuture future = serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        }finally {
            // 优雅关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}
