package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;

public class App
{
    public static void main(String[] args) {
        Person person1 = new Person(1,"Erik","Brink","erik@test.com");
        Person person2 = new Person(2,"Bob","Kyrby","bob@test.com");
        Person person3 = new Person(3,"Steve","Ström","steve@test.com");

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println(person1.getEmail());
        System.out.println(person2.getFirstName());
        System.out.println(person3.getLastName());

        // ToDoItem
        TodoItem todoItem1 = new TodoItem(1,"Create a website layout","website", LocalDate.of(2024,05,05),true);
        TodoItem todoItem2 = new TodoItem(2,"Create a ToDo app","app", LocalDate.of(2024,06,06),true);
        TodoItem todoItem3 = new TodoItem(3,"Create a Vending Machine app","app", LocalDate.of(2024,04,02),true);

        System.out.println(todoItem1);
        System.out.println(todoItem2);
        System.out.println(todoItem3);

        System.out.println(todoItem1);
        System.out.println(todoItem2);
        System.out.println(todoItem3);

        System.out.println(todoItem1.isOverdue());
        System.out.println(todoItem2.isOverdue());
        System.out.println(todoItem3.isOverdue());

        //TodoTask
        TodoItemTask todoItemTask1 = new TodoItemTask(1,true,"Create a website","Person1");
        System.out.println(todoItemTask1);



        TodoItemTask todoItemTask2 = new TodoItemTask();
        todoItemTask2.setAssignee(person2);
        todoItemTask2.setTodoItem(todoItem2);
        todoItemTask2.setAssigned(true);


        TodoItemTask todoItemTask3 = new TodoItemTask();







    }
    }

