package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoItemDaoImplTest {
    private TodoItemDaoImpl testObject;


    @BeforeEach
    public void setUp() {
        testObject = new TodoItemDaoImpl(); // Initialize test object before each test
    }

    @Test
    public void testCreateTodoItem() {
        TodoItem todoItem = new TodoItem(1,"Title","Task description", LocalDate.of(2024,04,14),true);

       testObject.persist(todoItem);
        assertTrue(testObject.findAll().contains(todoItem));

    }
    @Test
    public void testFindById(){
        TodoItem todoItem = new TodoItem(1, "Title", "Task description",LocalDate.of(2024,04,16),true);
        testObject.persist(todoItem);

        Optional<TodoItem> actualValue = testObject.findById(1);
        assertTrue( actualValue.isPresent());
        assertEquals(todoItem, actualValue.get());
    }
    @Test
    public void testFindByTitle(){
        TodoItem todoItem = new TodoItem(1, "Title", "Task description",LocalDate.of(2024,04,16),true);
        testObject.persist(todoItem);

        Collection<TodoItem> actualValue = testObject.findByTitleContains("Title");

        boolean found = false;
        for (TodoItem item : actualValue) {
            if (item.getTitle().equals("Title")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

}
