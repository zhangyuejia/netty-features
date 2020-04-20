package io.zhangyj.nio;

import java.nio.ByteBuffer;

/**
 * @author ZHANG-YJ
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
//        readOnlyBuffer.put(0, (byte) 1);
        ByteBuffer.allocateDirect(10);
    }
}
