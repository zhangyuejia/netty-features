package io.zhangyj.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class NioTest6 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        // 对当前可读写的部分生成一个快照buffer，共享底层数组
        buffer.position(2);
        buffer.limit(5);
        ByteBuffer slice = buffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get();
            b *=2;
            slice.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());
        for (int i = 0; i < buffer.capacity(); i++) {
            log.info(buffer.get() + "");
        }
    }
}

