package se.lexicon.data;


import se.lexicon.model.TodoItemTask;

import java.util.Collection;
import java.util.Optional;

public interface TodoItemTaskDao {
    TodoItemTask persist(TodoItemTask todoItemTask);

    Optional <TodoItemTask> findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int id);
    Collection<TodoItemTask> findAll();
    boolean remove(int id);
}
