package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDaoImplTest {



    private PersonDaoImpl testObject;


    @BeforeEach
    public void setUp() {
        testObject = new PersonDaoImpl(); // Initialize test object before each test
    }

    @Test
    public void testCreatePerson() {
        Person person = new Person(1,"John","Doe","test@test");

        Person actualValue = testObject.persist(person);
        Person expectedValue = person;

        assertEquals(expectedValue, actualValue);
        assertTrue(testObject.findById(1).isPresent());
    }

    @Test
    public void testFindById(){
        Person person = new Person(1, "John", "Doe","test@test");
        testObject.persist(person);

        Optional<Person> actualValue = testObject.findById(1);
        assertTrue( actualValue.isPresent());
        assertEquals(person, actualValue.get());
    }
    @Test
    public void testFindByEmail(){
        Person person = new Person(1, "John", "Doe","test@test");
        testObject.persist(person);

        Optional<Person> actualValue = testObject.findByEmail("test@test");
        assertTrue(actualValue.isPresent());
        assertEquals(person,actualValue.get());
    }
    @Test
    public void testRemovePerson(){
        Person person = new Person(1, "John", "Doe","test@test");
        testObject.persist(person);

        boolean actualResult = testObject.remove(1);
        assertTrue(actualResult);
        assertFalse(testObject.findById(1).isPresent());
    }

    @Test
    public void testFindAllPerson(){
        Person person1 = new Person(1, "John", "Doe","test1@test");
        Person person2 = new Person(2, "Jenny", "Kirby","test2@test");
        testObject.persist(person1);
        testObject.persist(person2);

        List<Person> actualPerson = testObject.findAll();
        List<Person> expectedPerson = Arrays.asList(person1, person2);

        assertEquals(actualPerson,expectedPerson);

    }




}
