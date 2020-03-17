package io.zhangyj.netty.fourth8heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author ZHANG-YJ
 */
public class MyHeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent) evt;
            String stateDesc;
            switch (event.state()){
                case READER_IDLE:
                    stateDesc = "读空闲";
                    break;
                case WRITER_IDLE:
                    stateDesc = "写空闲";
                    break;
                case ALL_IDLE:
                    stateDesc = "读写空闲";
                    break;
                default:
                    stateDesc = "";
                     break;
            }
            String content = ctx.channel().remoteAddress() + stateDesc;
            System.out.println(content);
            /// 关闭连接
            ctx.close();
        }
    }
}
