package io.zhangyj.proto3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class GrpcServer {

    private static final int PORT = 8899;

    private Server server;

    private void startServer() throws IOException {
        server = ServerBuilder.forPort(PORT).addService(new MyServiceImpl()).build();
        server.start();
        log.info("Server started, listening on " + PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.error("JVM shutdown. Stop the server");
            GrpcServer.this.stopServer();
        }));
    }

    public static void main(String[] args) throws Exception {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.startServer();
        grpcServer.blockUntilShutdown();
    }

    private void stopServer(){
        if(null != server){
            server.shutdown();
        }
    }
    private void blockUntilShutdown() throws InterruptedException {
        if(null != server){
            server.awaitTermination();
        }
    }


}
