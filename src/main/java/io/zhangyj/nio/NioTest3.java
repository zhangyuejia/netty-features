package io.zhangyj.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ZHANG-YJ
 */
public class NioTest3 {

    public static void main(String[] args) throws Exception{
        FileOutputStream fileInputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        String text = "hello world";
        // capacity: 512, position: 0, limit: 512
        NioTest2.printBufferInfo(byteBuffer);
        byteBuffer.put(text.getBytes());
        // capacity: 512, position: 11, limit: 512
        NioTest2.printBufferInfo(byteBuffer);
        byteBuffer.flip();
        // capacity: 512, position: 0, limit: 11
        NioTest2.printBufferInfo(byteBuffer);
        channel.write(byteBuffer);
        // capacity: 512, position: 11, limit: 11
        NioTest2.printBufferInfo(byteBuffer);
        fileInputStream.close();
    }
}
