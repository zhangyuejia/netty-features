package io.zhangyj.netty.fifth8websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @author ZHANG-YJ
 */
public class MyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        System.out.println("收到消息:" + msg.text());
        ctx.channel().writeAndFlush("服务器时间："+ LocalDateTime.now());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("连接加入："+ ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("连接断开："+ ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("发生异常，连接断开");
        ctx.close();
    }
}
