package io.zhangyj.netty.seventh8thirft;

import io.zhangyj.thrift.DataException;
import io.zhangyj.thrift.Person;
import io.zhangyj.thrift.PersonService;
import org.apache.thrift.TException;

/**
 * @author ZHANG-YJ
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("PersonService.getPersonByUsername:accept username: " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("PersonService.savePerson: accept person:" + person);

    }
}
