package se.lexicon.data.impl;

import se.lexicon.data.PersonDao;
import se.lexicon.data.sequencer.PersonIdSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {

    private List<Person> storage = new ArrayList<>();
    //Constructor
    public PersonDaoImpl(List<Person> storage, int currentId) {
        this.storage = storage;
    }

    @Override
    //persist: add new Person.class object to collection
    public Person persist(Person person) {
        if(person == null) throw new IllegalArgumentException("Person data is null");
        int currentId = PersonIdSequencer.nextId();
        person.setId(currentId);
        Optional<Person> personOptional = findById(person.getId());
        if (personOptional.isPresent()) throw new IllegalArgumentException("Person Id is duplicate");
        storage.add(person);
        return person;

    }

    //findById: returns single Person.class object
    @Override
    public Optional<Person> findById(int id) {
        for (Person person : storage) {
            if (person.getId() == id) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }
    //findByEmail: returns single Person.class object
    @Override
    public Optional<Person> findByEmail(String email) {
        for (Person person : storage) {
            if (person.getEmail() == email) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }
    //findAll: returns all Person.class objects
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public boolean remove(int id) {
        Optional<Person> personOptional = findById(id);
        if (!personOptional.isPresent()) return false;
        storage.remove(personOptional.get());
        return true;

    }
}
