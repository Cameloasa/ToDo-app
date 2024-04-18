package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void testFindByPersonId(){
        // Create a person
        Person person = new Person(1,"John","Doe","test");
        // Create a todoItem associated with the person
        TodoItem todoItem = new TodoItem(1, "Title", "Task description",LocalDate.of(2024,04,16),true);
        //Set person(Creator)
        todoItem.setCreator(person);
        // Persist the todoItem
        testObject.persist(todoItem);
        // Find todoItems by person ID
        Collection<TodoItem> actualValue = testObject.findByPersonId(person.getId());
        // Assert that the actualValue contains the todoItem
        assertTrue( actualValue.contains(todoItem));

    }

    @Test
    public void testFindByDeadlineBefore(){
        // Create a list of TodoItem objects with various deadlines
        TodoItem todoItem1 = new TodoItem(1, "Task 1", "Description 1", LocalDate.of(2024, 4, 10), true);
        TodoItem todoItem2 = new TodoItem(2, "Task 2", "Description 2", LocalDate.of(2024, 4, 15), true);
        TodoItem todoItem3 = new TodoItem(3, "Task 3", "Description 3", LocalDate.of(2024, 4, 20), true);
        TodoItem todoItem4 = new TodoItem(4, "Task 4", "Description 4", LocalDate.of(2024, 4, 25), true);
        TodoItem todoItem5 = new TodoItem(5, "Task 5", "Description 5", LocalDate.of(2024, 4, 30), true);
        // Persist the TodoItem objects
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);
        testObject.persist(todoItem3);
        testObject.persist(todoItem4);
        testObject.persist(todoItem5);
        // Define the deadline to search before
        LocalDate deadlineToSearchBefore = LocalDate.of(2024, 4, 22);

        // Call the findByDeadlineBefore method
        Collection<TodoItem> foundItems = testObject.findByDeadlineBefore(deadlineToSearchBefore);
        for (TodoItem item : foundItems) {
            assertEquals(true, item.getDeadLine().isBefore(deadlineToSearchBefore));
        }
    }
    @Test
    public void testFindByDeadlineAfter() {
        // Create a list of TodoItem objects with various deadlines
        TodoItem todoItem1 = new TodoItem(1, "Task 1", "Description 1", LocalDate.of(2024, 4, 10), true);
        TodoItem todoItem2 = new TodoItem(2, "Task 2", "Description 2", LocalDate.of(2024, 4, 15), true);
        TodoItem todoItem3 = new TodoItem(3, "Task 3", "Description 3", LocalDate.of(2024, 4, 20), true);
        TodoItem todoItem4 = new TodoItem(4, "Task 4", "Description 4", LocalDate.of(2024, 4, 25), true);
        TodoItem todoItem5 = new TodoItem(5, "Task 5", "Description 5", LocalDate.of(2024, 4, 30), true);
        // Persist the TodoItem objects
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);
        testObject.persist(todoItem3);
        testObject.persist(todoItem4);
        testObject.persist(todoItem5);
        // Define the deadline to search after
        LocalDate deadlineToSearchAfter = LocalDate.of(2024, 4, 14);

        Collection<TodoItem> foundItems = testObject.findByDeadLineAfter(deadlineToSearchAfter);
        // Call the findByDeadlineAfter method
        for (TodoItem item : foundItems){
            assertEquals(true,item.getDeadLine().isAfter(deadlineToSearchAfter));
        }

    }
    @Test
    public void testDoneStatus(){
        // Create a list of TodoItem objects with various deadlines
        TodoItem todoItem1 = new TodoItem(1, "Task 1", "Description 1", LocalDate.of(2024, 4, 10), true);
        TodoItem todoItem2 = new TodoItem(2, "Task 2", "Description 2", LocalDate.of(2024, 4, 15), true);
        TodoItem todoItem3 = new TodoItem(3, "Task 3", "Description 3", LocalDate.of(2024, 4, 20), false);
        TodoItem todoItem4 = new TodoItem(4, "Task 4", "Description 4", LocalDate.of(2024, 4, 25), false);
        TodoItem todoItem5 = new TodoItem(5, "Task 5", "Description 5", LocalDate.of(2024, 4, 30), false);
        // Persist the TodoItem objects
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);
        testObject.persist(todoItem3);
        testObject.persist(todoItem4);
        testObject.persist(todoItem5);

        // Define the done status to search for
        boolean doneStatusToSearchFor = true;

        // Call the findByDoneStatus method
        Collection<TodoItem> foundItems = testObject.findByDoneStatus(doneStatusToSearchFor);

        // Assert that foundItems is not null

        assertNotNull(foundItems);

        // Assert that each found item has the expected done status
        for (TodoItem item : foundItems) {
            assertTrue(item.isDone());
        }

    }

    @Test
    public void testRemoveTodoItem(){
        //create a todoItem
        TodoItem todoItem = new TodoItem(1, "Title", "Task description",LocalDate.of(2024,04,16),true);
        testObject.persist(todoItem);

        boolean actualResult = testObject.remove(1);
        assertTrue(actualResult);
        assertFalse(testObject.findById(1).isPresent());
    }


}
