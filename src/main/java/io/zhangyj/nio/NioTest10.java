package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 3.	Scattering和Gathering（分散和聚集）
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest10 {
    public static void main(String[] args) throws IOException {
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketChannel socketChannel = serverSocketChannel
                .bind(new InetSocketAddress(8899))
                .accept();

        int totalLength = 2 + 3 + 4;
        //noinspection InfiniteLoopStatement
        while (true){
            int readLength = 0;
            while (readLength < totalLength){
                long read = socketChannel.read(buffers);
                readLength += read;
                System.out.print(readLength +" ");
            }
            Arrays.stream(buffers)
                    .map(byteBuffer -> {return " position:" + byteBuffer.position() + " limit:" + byteBuffer.limit();})
                    .forEach(System.out::println);
            Arrays.stream(buffers).forEach(Buffer::flip);
            int writeLength = 0;
            while (writeLength < totalLength){
                long write = socketChannel.write(buffers);
                writeLength += write;
            }
            Arrays.stream(buffers).forEach(Buffer::clear);
        }

    }
}
