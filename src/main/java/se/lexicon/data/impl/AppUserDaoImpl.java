package se.lexicon.data.impl;

import se.lexicon.data.AppUserDao;
import se.lexicon.model.AppUser;

import java.util.List;
import java.util.Optional;

public class AppUserDaoImpl implements AppUserDao {
    @Override
    public AppUser persist(AppUser user) {
        return null;
    }

    @Override
    public Optional<AppUser> findByUserName(String email) {
        return Optional.empty();
    }

    @Override
    public List<AppUser> findAll() {
        return List.of();
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
