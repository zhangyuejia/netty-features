package io.zhangyj.proto3;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.FilterInputStream;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class GrpcClientTest {
    private static final int PORT = 8899;

    private MyServiceGrpc.MyServiceBlockingStub blockingStub;

    private MyServiceGrpc.MyServiceStub asyncStub;

    @Before
    public void before(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", PORT).usePlaintext().build();
        blockingStub = MyServiceGrpc.newBlockingStub(channel);
        asyncStub = MyServiceGrpc.newStub(channel);
    }

    private void waitForData(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void testSimpleRpc(){
        log.info("测试简单RPC");
        MyRequest request = MyRequest.newBuilder().setUserName("小林").build();
        log.info("1.请求服务端getRealName，参数：{}", request.getUserName());
        MyResponse response = blockingStub.getRealName(request);
        log.info("1.获得服务端响应：{}", response.getRealName());
    }

    private void testServerSideStreamRpc(){
        log.info("测试服务端流");
        StudentRequest studentRequest = StudentRequest.newBuilder().setAge(20).build();
        Iterator<StudentResponse> iterator = blockingStub.getStudentsByAge(studentRequest);
        log.info("2.请求服务端getStudentsByAge，参数:{}", studentRequest.getAge());
        while (iterator.hasNext()){
            StudentResponse next = iterator.next();
            log.info("2.获得服务端响应，年龄:{} 名字：{}", next.getAge(), next.getName());
        }
        log.info("-------------------------------");
    }

    private void testClientSideStreamRpc() {
        log.info("测试客户端流");
        // 用于处理服务端返回的数据
        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                log.info("接收到服务端数据");
                value.getResponseList().forEach(r -> log.info("姓名：{},年龄：{}", r.getName(), r.getAge()));
            }

            @Override
            public void onError(Throwable t) {
                log.error("发生错误", t);
            }

            @Override
            public void onCompleted() {
                log.info("结束");
            }
        };
        StreamObserver<StudentRequest> studentWrapperByAge = asyncStub.getStudentWrapperByAge(studentResponseListStreamObserver);
        // 发送数据
        studentWrapperByAge.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentWrapperByAge.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentWrapperByAge.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentWrapperByAge.onCompleted();
        waitForData();
    }

    private void testBiStreamRpc() {
        log.info("测试双向流PRC");
        StreamObserver<BiRequest> biRequestStreamObserver = asyncStub.biTalk(new StreamObserver<BiResponse>() {
            @Override
            public void onNext(BiResponse value) {
                log.info("接收到服务端数据:{}", value.getUuid());
            }

            @Override
            public void onError(Throwable t) {
                log.error("发生错误", t);
            }

            @Override
            public void onCompleted() {
                log.info("结束");
            }
        });
        biRequestStreamObserver.onNext(BiRequest.newBuilder().setUuid(UUID.randomUUID().toString()).build());
        biRequestStreamObserver.onNext(BiRequest.newBuilder().setUuid(UUID.randomUUID().toString()).build());
        biRequestStreamObserver.onNext(BiRequest.newBuilder().setUuid(UUID.randomUUID().toString()).build());
        biRequestStreamObserver.onNext(BiRequest.newBuilder().setUuid(UUID.randomUUID().toString()).build());
        waitForData();
    }

    @Test
    public void test(){
        testSimpleRpc();
//        testServerSideStreamRpc();
//        testClientSideStreamRpc();
//        testBiStreamRpc();
    }



}
