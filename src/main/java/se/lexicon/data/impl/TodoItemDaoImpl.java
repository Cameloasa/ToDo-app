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
import java.util.stream.Collectors;


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
        Optional<TodoItem> todoItemOptional = (findById(todoItem.getId()));
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

        // Create a list to store the matching todoItems
        List<TodoItem> foundItems = new ArrayList<>();

        // Iterate over each todoItem
        for (TodoItem item : todoItems) {
            // Check if the done status of the current item matches the provided status
            if (item.isDone() == done) {
                // If it matches, add the item to the foundItems list
                foundItems.add(item);
            }
        }

        // Return the list of matching todoItems
        return foundItems;
    }

    @Override
    public boolean remove(int id) {
       //Iterate
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                todoItems.remove(item);
                return true;
            }
        }

        return false;
    }

    }








