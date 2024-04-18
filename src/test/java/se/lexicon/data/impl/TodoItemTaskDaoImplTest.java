package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoItemTaskDaoImplTest {
    private TodoItemTaskDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new TodoItemTaskDaoImpl();
    }

    @Test
    public void testCreateTodoItemTask() {
        TodoItemTask todoItemTask = new TodoItemTask(1, true, "Task description", "Person1");
        testObject.persist(todoItemTask);

        assertTrue(testObject.findById(1).isPresent());
    }

    @Test
    public void testFindByPersonId() {
        // Create a person
        Person person = new Person(1, "John", "Doe", "test");
        // Create a todoItem associated with the person
        TodoItemTask todoItemTask = new TodoItemTask(1, true, "Task description", "Person1");
        //Set person(Creator)
        todoItemTask.setAssignee(person);
        // Persist the todoItem
        testObject.persist(todoItemTask);
        // Find todoItems by person ID
        Collection<TodoItemTask> actualValue = testObject.findByPersonId(person.getId());
        // Assert that the actualValue contains the todoItem
        assertTrue(actualValue.contains(todoItemTask));
    }

    @Test
    public void testFindAllTask(){
        TodoItemTask todoItemTask1 = new TodoItemTask(1, true, "Task description 1", "Person1");
        TodoItemTask todoItemTask2 = new TodoItemTask(2, true, "Task description 2", "Person2");
        testObject.persist(todoItemTask1);
        testObject.persist(todoItemTask2);

        Collection<TodoItemTask> actualTasks = testObject.findAll();
        List<TodoItemTask> expectedTasks = Arrays.asList(todoItemTask1, todoItemTask2);

        assertEquals(actualTasks,expectedTasks);

    }

    @Test
    public void testFindByAssignedStatus(){

    }

    @Test
    public void testRemove(){

    }

}
