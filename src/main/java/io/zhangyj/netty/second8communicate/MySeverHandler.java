package io.zhangyj.netty.second8communicate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author ZHANG-YJ
 */
public class MySeverHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("server receive from:"+ ctx.channel().remoteAddress()+" msg:" + msg);
        ctx.writeAndFlush("hello I am server!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.writeAndFlush("1");
    }
}
