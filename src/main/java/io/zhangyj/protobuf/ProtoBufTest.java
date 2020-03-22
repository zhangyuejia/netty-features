package io.zhangyj.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author ZHANG-YJ
 */
public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("乐+").setAge(26).setAddress("揭阳").build();
        byte[] bytes = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student1.toString());
        System.out.println(student1.getName());
        System.out.println(student1.getAddress());
        System.out.println(student1.getAge());
    }
}
