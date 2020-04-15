package io.zhangyj.proto3;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZHANG-YJ
 */
@Slf4j
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void getRealName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        log.info("接收到客户端信息:{}", request.getUserName());
        MyResponse response = MyResponse.newBuilder().setRealName("小章").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        log.info("接收到客户端信息:{}", request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(20).setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(30).setName("李四").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(40).setName("王五").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAge(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {


            @Override
            public void onNext(StudentRequest value) {
                log.info("接收到客户端信息:{}", value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                log.error("发生错误", t);
            }

            @Override
            public void onCompleted() {
                StudentResponse response = StudentResponse.newBuilder().setAge(ThreadLocalRandom.current().nextInt()).setName("小林").build();
                StudentResponse response2 = StudentResponse.newBuilder().setAge(ThreadLocalRandom.current().nextInt()).setName("小章").build();
                StudentResponseList responseList = StudentResponseList.newBuilder().addResponse(response).addResponse(response2).build();
                responseObserver.onNext(responseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<BiRequest> biTalk(StreamObserver<BiResponse> responseObserver) {
        return new StreamObserver<BiRequest>() {
            @Override
            public void onNext(BiRequest value) {
                log.info("双向流：收到客户端数据{}", value.getUuid());
                responseObserver.onNext(BiResponse.newBuilder().setUuid(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                log.error("发生错误", t);
            }

            @Override
            public void onCompleted() {
                // 双向通讯一般一端结束，另一端也结束
                responseObserver.onCompleted();
            }
        };
    }
}