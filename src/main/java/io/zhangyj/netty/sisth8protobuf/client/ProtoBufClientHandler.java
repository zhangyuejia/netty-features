package io.zhangyj.netty.sisth8protobuf.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.zhangyj.netty.sisth8protobuf.protobuf.DataInfo;

/**
 * @author ZHANG-YJ
 */
public class ProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Data> {
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
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("我是客户端").setAge(30).setAddress("揭阳").build();
        ctx.writeAndFlush(DataInfo.Data.newBuilder()
                .setStudent(student).setDataType(DataInfo.Data.DataType.Student)
                .build());
    }
}
