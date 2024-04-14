package se.lexicon.data.impl;

import se.lexicon.data.TodoItemTaskDao;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDaoImpl implements TodoItemTaskDao {

    private Collection<TodoItemTaskDao> todoItemTasks;

    public TodoItemTask() {
        todoItemTasks = new ArrayList<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTaskDao todoItemTask) {

        if (todoItemTask == null) {
            throw new IllegalArgumentException("TodoItemTask cannot be null");
        }
        todoItemTasks.add(todoItemTask);
        return this;

    }

    @Override
    public TodoItemTask findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        return List.of();
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        return List.of();
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return List.of();
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
