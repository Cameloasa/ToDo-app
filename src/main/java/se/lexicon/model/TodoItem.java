package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    // Fields

    private int id; // representing each To Do element
    private String title ; // ex make your own code, change tires Not allowed to be null
    private String taskDescription; // hold further information
    private LocalDate deadLine; // not allowed to be null
    private boolean done; // if task is finished
    private Person creator;

    //Constructor
    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, boolean done) {
        this.id = id;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.done = done;

    }
    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public boolean isDone() {
        return done;
    }



    public Person getCreator() {
        return creator;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if(title == null) throw new IllegalArgumentException("This field cannot be empty");
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null) throw new IllegalArgumentException("This field cannot be empty");
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if(deadLine == null) throw new IllegalArgumentException("This field cannot be empty");
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    // Method isOverdue
    public boolean isOverdue(){
        return LocalDate.now().isAfter(deadLine);
    }
    // Method getSummary


    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", creator=" + creator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine) && Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, taskDescription, deadLine, done, creator);
    }




}
