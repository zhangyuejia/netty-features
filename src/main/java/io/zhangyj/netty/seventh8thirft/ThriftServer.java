package io.zhangyj.netty.seventh8thirft;

import io.zhangyj.thrift.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TZlibTransport;

/**
 * @author ZHANG-YJ
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        // 获取服务参数
        THsHaServer.Args arg = getServerArgs(socket);
        // 创建并启动服务
        THsHaServer server = new THsHaServer(arg);
        server.serve();
    }

    private static THsHaServer.Args getServerArgs(TNonblockingServerSocket socket) {
        THsHaServer.Args args = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        args.processorFactory(new TProcessorFactory(processor));
        // 传输层
        args.transportFactory(new TFramedTransport.Factory());
        // 协议层
        args.protocolFactory(new TCompactProtocol.Factory());
        return args;
    }
}
