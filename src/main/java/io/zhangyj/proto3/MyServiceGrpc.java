package io.zhangyj.proto3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: Student.proto")
public final class MyServiceGrpc {

  private MyServiceGrpc() {}

  public static final String SERVICE_NAME = "io.zhangyj.proto3.MyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.zhangyj.proto3.MyRequest,
      io.zhangyj.proto3.MyResponse> getGetRealNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealName",
      requestType = io.zhangyj.proto3.MyRequest.class,
      responseType = io.zhangyj.proto3.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.zhangyj.proto3.MyRequest,
      io.zhangyj.proto3.MyResponse> getGetRealNameMethod() {
    io.grpc.MethodDescriptor<io.zhangyj.proto3.MyRequest, io.zhangyj.proto3.MyResponse> getGetRealNameMethod;
    if ((getGetRealNameMethod = MyServiceGrpc.getGetRealNameMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getGetRealNameMethod = MyServiceGrpc.getGetRealNameMethod) == null) {
          MyServiceGrpc.getGetRealNameMethod = getGetRealNameMethod =
              io.grpc.MethodDescriptor.<io.zhangyj.proto3.MyRequest, io.zhangyj.proto3.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("GetRealName"))
              .build();
        }
      }
    }
    return getGetRealNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest,
      io.zhangyj.proto3.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAge",
      requestType = io.zhangyj.proto3.StudentRequest.class,
      responseType = io.zhangyj.proto3.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest,
      io.zhangyj.proto3.StudentResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest, io.zhangyj.proto3.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = MyServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = MyServiceGrpc.getGetStudentsByAgeMethod) == null) {
          MyServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod =
              io.grpc.MethodDescriptor.<io.zhangyj.proto3.StudentRequest, io.zhangyj.proto3.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("GetStudentsByAge"))
              .build();
        }
      }
    }
    return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest,
      io.zhangyj.proto3.StudentResponseList> getGetStudentWrapperByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAge",
      requestType = io.zhangyj.proto3.StudentRequest.class,
      responseType = io.zhangyj.proto3.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest,
      io.zhangyj.proto3.StudentResponseList> getGetStudentWrapperByAgeMethod() {
    io.grpc.MethodDescriptor<io.zhangyj.proto3.StudentRequest, io.zhangyj.proto3.StudentResponseList> getGetStudentWrapperByAgeMethod;
    if ((getGetStudentWrapperByAgeMethod = MyServiceGrpc.getGetStudentWrapperByAgeMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getGetStudentWrapperByAgeMethod = MyServiceGrpc.getGetStudentWrapperByAgeMethod) == null) {
          MyServiceGrpc.getGetStudentWrapperByAgeMethod = getGetStudentWrapperByAgeMethod =
              io.grpc.MethodDescriptor.<io.zhangyj.proto3.StudentRequest, io.zhangyj.proto3.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentWrapperByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.StudentResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("GetStudentWrapperByAge"))
              .build();
        }
      }
    }
    return getGetStudentWrapperByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.zhangyj.proto3.BiRequest,
      io.zhangyj.proto3.BiResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biTalk",
      requestType = io.zhangyj.proto3.BiRequest.class,
      responseType = io.zhangyj.proto3.BiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.zhangyj.proto3.BiRequest,
      io.zhangyj.proto3.BiResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<io.zhangyj.proto3.BiRequest, io.zhangyj.proto3.BiResponse> getBiTalkMethod;
    if ((getBiTalkMethod = MyServiceGrpc.getBiTalkMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getBiTalkMethod = MyServiceGrpc.getBiTalkMethod) == null) {
          MyServiceGrpc.getBiTalkMethod = getBiTalkMethod =
              io.grpc.MethodDescriptor.<io.zhangyj.proto3.BiRequest, io.zhangyj.proto3.BiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "biTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.BiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.zhangyj.proto3.BiResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("biTalk"))
              .build();
        }
      }
    }
    return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceStub>() {
        @java.lang.Override
        public MyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceStub(channel, callOptions);
        }
      };
    return MyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub>() {
        @java.lang.Override
        public MyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceBlockingStub(channel, callOptions);
        }
      };
    return MyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub>() {
        @java.lang.Override
        public MyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceFutureStub(channel, callOptions);
        }
      };
    return MyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealName(io.zhangyj.proto3.MyRequest request,
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentsByAge(io.zhangyj.proto3.StudentRequest request,
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentRequest> getStudentWrapperByAge(
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.zhangyj.proto3.BiRequest> biTalk(
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.BiResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.zhangyj.proto3.MyRequest,
                io.zhangyj.proto3.MyResponse>(
                  this, METHODID_GET_REAL_NAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.zhangyj.proto3.StudentRequest,
                io.zhangyj.proto3.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentWrapperByAgeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.zhangyj.proto3.StudentRequest,
                io.zhangyj.proto3.StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGE)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.zhangyj.proto3.BiRequest,
                io.zhangyj.proto3.BiResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class MyServiceStub extends io.grpc.stub.AbstractAsyncStub<MyServiceStub> {
    private MyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealName(io.zhangyj.proto3.MyRequest request,
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsByAge(io.zhangyj.proto3.StudentRequest request,
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentRequest> getStudentWrapperByAge(
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgeMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.zhangyj.proto3.BiRequest> biTalk(
        io.grpc.stub.StreamObserver<io.zhangyj.proto3.BiResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MyServiceBlockingStub> {
    private MyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.zhangyj.proto3.MyResponse getRealName(io.zhangyj.proto3.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.zhangyj.proto3.StudentResponse> getStudentsByAge(
        io.zhangyj.proto3.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MyServiceFutureStub> {
    private MyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.zhangyj.proto3.MyResponse> getRealName(
        io.zhangyj.proto3.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGE = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME:
          serviceImpl.getRealName((io.zhangyj.proto3.MyRequest) request,
              (io.grpc.stub.StreamObserver<io.zhangyj.proto3.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((io.zhangyj.proto3.StudentRequest) request,
              (io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAge(
              (io.grpc.stub.StreamObserver<io.zhangyj.proto3.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<io.zhangyj.proto3.BiResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.zhangyj.proto3.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MyService");
    }
  }

  private static final class MyServiceFileDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier {
    MyServiceFileDescriptorSupplier() {}
  }

  private static final class MyServiceMethodDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MyServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MyServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentWrapperByAgeMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
