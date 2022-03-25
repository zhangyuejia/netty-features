package io.zhangyj.nettyapp.largeconns;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

    private static final String SERVER_HOST = "192.169.7.222";

    public static void main(String[] args) {
        new Client().start(Server.BEGIN_PORT, Server.N_PORT);
    }

    public void start(final int beginPort, int nPort) {
        System.out.println("客户端已启动...");
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
            }
        });

        int index = 0;
        int port;
        while (!Thread.interrupted()) {

            port = beginPort + index;
            try {
                ChannelFuture channelFuture = bootstrap.connect(SERVER_HOST, port);
                channelFuture.addListener((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        System.exit(0);
                    }
                });
                channelFuture.get();
            } catch (Exception e) {
            }

            if (port == nPort) { index = 0; }else { index ++; }
        }
    }
}