package se.lexicon.data;

import se.lexicon.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

    Person persist(Person person);//persist: add new Person.class object to
    //collection

    Optional<Person> findById(int id);//findById: returns single Person.class object
    Optional<Person> findByEmail(String email);//findById: returns single Person.class object
    List <Person> findAll();//findAll: returns all Person.class objects
    boolean remove(int id);//remove: remove one Person.class object from collection






}
