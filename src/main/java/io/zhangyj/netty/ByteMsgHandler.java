package io.zhangyj.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * @author ZHANG-YJ
 */
public class ByteMsgHandler extends ByteToMessageDecoder {

    private static final int HEAD_LENGTH = 8;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() < HEAD_LENGTH){
            return;
        }

    }
}
