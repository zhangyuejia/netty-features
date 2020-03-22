package io.zhangyj.netty.sisth8protobuf.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.zhangyj.netty.sisth8protobuf.protobuf.DataInfo;

/**
 * @author ZHANG-YJ
 */
public class ProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Data msg) throws Exception {
        System.out.println("收到对象：" + msg.getDataType());
        switch (msg.getDataType()){
            case Student:
                DataInfo.Student student = msg.getStudent();
                System.out.println(student.getName());
                System.out.println(student.getAddress());
                System.out.println(student.getAge());
                break;
            case Teacher:
                DataInfo.Teacher teacher = msg.getTeacher();
                System.out.println(teacher.getName());
                System.out.println(teacher.getLessonName());
                break;
            default:
                break;
        }
        DataInfo.Teacher teacher = DataInfo.Teacher.newBuilder()
                .setName("我是服务端").setLessonName("语文").build();
        ctx.writeAndFlush(DataInfo.Data.newBuilder()
                .setTeacher(teacher).setDataType(DataInfo.Data.DataType.Teacher)
                .build());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive:" + ctx.channel().id().asLongText());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInActive:" + ctx.channel().id().asLongText());
    }
}
