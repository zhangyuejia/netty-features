package io.zhangyj.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 传统网络模型
 * @author ZHANG-YJ
 */
public class NioTest11 {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(2,
            100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "test-task");
        }
    });

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        //noinspection InfiniteLoopStatement
        while (true){
            Socket socket = serverSocket.accept();
            // 必须另起线程进行业务处理
            EXECUTOR.execute(()->handleSocket(socket));
        }
    }

    private static void handleSocket(Socket socket) {
        // 等等操作
    }
}
