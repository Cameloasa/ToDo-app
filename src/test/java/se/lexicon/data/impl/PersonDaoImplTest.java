package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDaoImplTest {

    private PersonDaoImpl testObject;


    @BeforeEach
    public void setUp() {
        testObject = new PersonDaoImpl(); // Initialize test object before each test
    }

    @Test
    public void testCreatePerson() {
        Person person = new Person(1,"John","Doe","test");

        Person actualValue = testObject.persist(person);
        Person expectedValue = person;

        assertEquals(expectedValue, actualValue);
        assertTrue(testObject.findById(1).isPresent());
    }

}
