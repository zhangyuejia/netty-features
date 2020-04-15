package io.zhangyj.nio;

import org.junit.Test;

import java.nio.IntBuffer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZHANG-YJ
 */
public class NioTest1 {

    @Test
    public void test(){
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
