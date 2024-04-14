package se.lexicon.data.impl;

import se.lexicon.data.TodoItemDao;
import se.lexicon.data.sequencer.TodoItemIdSequencer;
import se.lexicon.model.TodoItem;
import java.time.LocalDate;
import java.util.*;



public class TodoItemDaoImpl implements TodoItemDao {

    private final Collection<TodoItem> todoItems;

    public TodoItemDaoImpl() {
        todoItems = new ArrayList<>();
    }

    @Override
    public TodoItemDao persist(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("TodoItem cannot be null");
        }
        todoItems.add(todoItem);
        return this;

    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getTitle().contains(title)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getId() == personId) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate deadLine) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isBefore(deadLine)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate deadLine) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isAfter(deadLine)) {
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        TodoItem itemToRemove = null;
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            todoItems.remove(itemToRemove);
        }
        return false;
    }

    }








