package se.lexicon.data.impl;

import se.lexicon.data.AppUserDao;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppUserDaoImpl implements AppUserDao {

    private List<AppUser> usersCollection;

    public AppUserDaoImpl() {
        this.usersCollection = new ArrayList<>();
    }

    @Override
    //persist: add new App User.class object to collection
    public AppUser persist(AppUser user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        usersCollection.add(user);
        return user;
    }

    @Override
    //findByUserName(String email);
    public Optional<AppUser> findByUserName(String email) {
        for (AppUser user : usersCollection) {
            if (user.getUsername().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();

    }

    @Override
    ////findAll: returns all User.class objects
    public List<AppUser> findAll() {
        return new ArrayList<>(usersCollection);
    }

    @Override
    //remove: remove one User.class object from collection
    public boolean remove(String username) {
        for (AppUser user : usersCollection) {
            if (user.getUsername().equals(username)) {
                usersCollection.remove(user);
                return true;
            }
        }
        return false;
    }
}
