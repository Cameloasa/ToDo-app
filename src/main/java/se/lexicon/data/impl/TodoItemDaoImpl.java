package se.lexicon.data.impl;

import se.lexicon.data.TodoItemDao;
import se.lexicon.data.sequencer.PersonIdSequencer;
import se.lexicon.data.sequencer.TodoItemIdSequencer;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.List;



public class TodoItemDaoImpl implements TodoItemDao {

    private final Collection<TodoItem> todoItems;

    public TodoItemDaoImpl() {
        todoItems = new ArrayList<>();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("Data is null");
        int currentId = TodoItemIdSequencer.nextId();
        todoItem.setId(currentId);
        Optional<TodoItem> todoItemOptional = Optional.ofNullable(findById(todoItem.getId()));
        if (todoItemOptional.isPresent()) throw new IllegalArgumentException("Item Id is duplicate");
        todoItems.add(todoItem);
        return todoItem;


    }

    @Override
    public Optional<TodoItem> findById(int id) {
        for (TodoItem todoItem : todoItems) {
            if (todoItem.getId() == id) {
                return Optional.of(todoItem);
            }
        }
        return Optional.empty();
    }

    @Override
    public List <TodoItem> findAll() {
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








