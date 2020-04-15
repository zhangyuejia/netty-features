package io.zhangyj.nio;

import io.netty.buffer.ByteBuf;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ZHANG-YJ
 */
public class NioTest2 {

    @Test
    public void testNioRead() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);
        NioTest2.printBuffeInfo(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
//            NioTest2.printBuffeInfo(byteBuffer);
            byte b = byteBuffer.get();
            System.out.println("read byte:" + (char)b);
        }
        fileInputStream.close();
    }

    static void printBuffeInfo(Buffer buffer){
        String format = String.format("{capacity: %d, position: %d, limit: %d}",
                buffer.capacity(), buffer.position(), buffer.limit());
        System.out.println(format);
    }
}
