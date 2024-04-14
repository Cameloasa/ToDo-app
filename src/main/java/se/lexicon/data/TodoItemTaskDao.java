package se.lexicon.data;

import com.sun.tools.javac.util.List;
import se.lexicon.model.TodoItemTask;

import java.util.Optional;

public interface TodoItemTaskDao {
    TodoItemTask persist(TodoItemTask todoItemTask);

    Optional <TodoItemTask> findById(int id);
    List<TodoItemTask> findByAssignedStatus(boolean assigned);
    List<TodoItemTask> findByPersonId(int id);
    List<TodoItemTask> findAll();
    boolean remove(int id);
}
