package se.lexicon.data.impl;

import se.lexicon.data.TodoItemTaskDao;
import se.lexicon.data.sequencer.TodoItemTaskIdSequencer;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class TodoItemTaskDaoImpl implements TodoItemTaskDao {

    private final Collection<TodoItemTask> todoItemTasks;

    public TodoItemTaskDaoImpl() {
       todoItemTasks = new ArrayList<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {

        if(todoItemTask == null) throw new IllegalArgumentException("Data is null");
        int currentId = TodoItemTaskIdSequencer.nextId();
        todoItemTask.setId(currentId);
        Optional<TodoItemTask> todoItemOptional = Optional.ofNullable(findById(todoItemTask.getId()));
        if (todoItemOptional.isPresent()) throw new IllegalArgumentException("Item Id is duplicate");
        todoItemTasks.add(todoItemTask);
        return todoItemTask;

    }

    @Override
    public Optional <TodoItemTask>findById(int id) {
        for (TodoItemTask todoItemTask : todoItemTasks) {
            if (todoItemTask.getId() == id) {
                return Optional.of(todoItemTask);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTasks) {
            if (task.isAssigned() == assigned) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public List<TodoItemTask> findByPersonId(int id) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTasks) {
            if (task.getAssignee() != null && task.getAssignee().getId() == personId) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTask);
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
