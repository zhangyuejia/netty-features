package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest4 {

    public static void main(String[] args) throws Exception{
        File file = new File("NioTest3.txt");
        File fileCopy = new File("NioTest4.txt");
        if(!file.exists()){
            log.info("文件不存在");
            return;
        }
        if(!fileCopy.exists()){
            fileCopy.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(124);
        ByteBuffer.allocateDirect(10);
        boolean run = true;
        while (run){
            byteBuffer.clear();
            // clear方法如果被注释，第二次循环read的值将会为0，
            // 因为此时的buffer limit等于position，导致死循环写入
            int read = inChannel.read(byteBuffer);
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            run = read != -1;
        }
        inChannel.close();
        outChannel.close();
    }
}
