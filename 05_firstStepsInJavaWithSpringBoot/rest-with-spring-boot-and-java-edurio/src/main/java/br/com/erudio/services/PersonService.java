package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service /*
Torna o objeto injetável em outra parte da aplicação

*/
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName()); //Logando no terminal

    public List<Person> findAll(){

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = MockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){

        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Marcos");
        person.setLasttname("Coelho");
        person.setAddress("Salvador - Bahêa");
        person.setGender("Male");

        return person;
    }

    private Person MockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Person name " + i);
        person.setLasttname("Last name " + i);
        person.setAddress("Some address in Brazil " + i);
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person!");


        return person;
    }

    public Person update(Person person){
        logger.info("Updating one person!");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person!");
    }
}
