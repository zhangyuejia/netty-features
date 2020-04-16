package io.zhangyj.nio;

import java.nio.IntBuffer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZHANG-YJ
 */
public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i=0; i<buffer.capacity(); i++){
            buffer.put(ThreadLocalRandom.current().nextInt(10));
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
