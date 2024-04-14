package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;

public interface TodoItemDao {

    TodoItemDao persist(TodoItem todoItem);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate deadLine);
    Collection<TodoItem> findByDeadLineAfter(LocalDate deadLine);
    Collection<TodoItem> findByDoneStatus(boolean done);
    boolean remove(int id);


}
