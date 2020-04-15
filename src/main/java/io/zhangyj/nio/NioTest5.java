package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest5 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(24);
        buffer.put((byte) 1);
        buffer.putInt(2);
        buffer.putChar('你');
        buffer.putDouble(0.01);
        buffer.putLong(3L);

        buffer.flip();
        log.info(buffer.get() + "");
        log.info(buffer.getInt() + "");
        log.info(buffer.getChar() + "");
        log.info(buffer.getDouble() + "");
        log.info(buffer.getLong() + "");


    }
}
