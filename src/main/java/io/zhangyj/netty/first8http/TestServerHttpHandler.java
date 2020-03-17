package io.zhangyj.netty.first8http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * 处理Http响应
 * @author ZHANG-YJ
 */
public class TestServerHttpHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 浏览器会发起两个请求，一个是空地址，一个是favicon.ico
        System.out.println("http msg type: " + msg.getClass().getName());
        if(msg instanceof HttpRequest){
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("http method:" + httpRequest.method() + " http uri:" + httpRequest.uri());
            final String favicon = "favicon.ico";
            if(httpRequest.uri().contains(favicon)){
                System.out.println("favicon.ico return directly！");
                return;
            }
            FullHttpResponse response = getHttpResponse();
            ctx.writeAndFlush(response);
        }
        // channel处理流程为： registered -> active -> channelRead -> inactive -> unregistered
        // 不显式对channel进行关闭的话，channel暂时不会关闭，得以复用，这也是http1.1 keep-alive特性
//        ctx.channel().close();
    }

    private FullHttpResponse getHttpResponse() {
        ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        HttpHeaders headers = response.headers();
        headers.set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        headers.set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        return response;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handler added");
        super.handlerAdded(ctx);
    }
}
