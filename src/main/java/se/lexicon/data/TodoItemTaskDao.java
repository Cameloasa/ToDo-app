package se.lexicon.data;

import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemTaskDao {
    TodoItemTask persist(TodoItemTaskDao todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int id);
    Collection<TodoItemTask> findAll();
    boolean remove(int id);
}
