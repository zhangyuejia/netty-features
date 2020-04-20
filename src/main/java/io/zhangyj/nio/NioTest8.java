package io.zhangyj.nio;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHANG-YJ
 */
public class NioTest8 {

    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("NioTest8.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 5);
        System.out.println("开始");
//        mappedByteBuffer.put(0, (byte) '你');
//        mappedByteBuffer.put(3, (byte) 'd');
        TimeUnit.SECONDS.sleep(10);
        System.out.println((char) mappedByteBuffer.get());
        fileChannel.close();
        accessFile.close();
    }
}
