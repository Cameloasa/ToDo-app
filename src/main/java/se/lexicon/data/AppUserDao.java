package se.lexicon.data;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    AppUser persist(AppUser user);//persist: add new App User.class object to
    Optional<AppUser> findByUserName(String email);
    List<AppUser> findAll();//findAll: returns all User.class objects
    boolean remove(int id);//remove: remove one User.class object from collection
}
