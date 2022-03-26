package io.zhangyj.netty.first8http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/**
 * 处理Http响应
 * @author ZHANG-YJ
 */
public class TestServerHttpHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 浏览器会发起两个请求，一个是空地址，一个是favicon.ico
        System.out.println("http msg type: " + msg.getClass().getName()+" channelId:" + ctx.channel().id().asLongText());
        if(msg instanceof HttpRequest){
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("http method:" + httpRequest.method() + " http uri:" + httpRequest.uri() );
            final String favicon = "favicon.ico";
            String data = httpRequest.uri().contains(favicon)? null: "Hello World";
            ctx.writeAndFlush(getHttpResponse(data));
        }
        // channel处理流程为： registered -> active -> channelRead -> inactive -> unregistered
        // 不显式对channel进行关闭的话，channel暂时不会关闭，得以复用，这也是http1.1 keep-alive特性
//        ctx.channel().close();
    }

    private FullHttpResponse getHttpResponse(String data) {
        FullHttpResponse response;
        if(StringUtil.isNullOrEmpty(data)){
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        }else {
            ByteBuf content = Unpooled.copiedBuffer(data, CharsetUtil.UTF_8);
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            HttpHeaders headers = response.headers();
            headers.set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            headers.set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        }
        return response;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active: " + ctx.channel().id().asLongText());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive: " + ctx.channel().id().asLongText());
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered: " + ctx.channel().id().asLongText());
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregistered: " + ctx.channel().id().asLongText());
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added: " + ctx.channel().id().asLongText());
        super.handlerAdded(ctx);
    }
}
