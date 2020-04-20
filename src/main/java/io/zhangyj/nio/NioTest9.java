package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest9 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("NioTest8.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        FileLock fileLock = fileChannel.lock();
        fileLock.release();
    }
}
