package io.zhangyj.netty.seventh8thirft;

import io.zhangyj.thrift.Person;
import io.zhangyj.thrift.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author ZHANG-YJ
 */
public class ThriftClient {
    public static void main(String[] args){
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 1000);
        TProtocol protocol = new TCompactProtocol(transport);
        try {
            transport.open();
            PersonService.Client client = new PersonService.Client(protocol);
            Person person = client.getPersonByUsername("乐佳");
            System.out.println(person);

            Person person1 = new Person();
            person1.setMarried(false);
            person1.setUsername("如");
            person1.setAge(18);
            client.savePerson(person1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transport.close();
        }
    }
}

