package se.lexicon.model;

import java.util.Objects;

public class AppUser {
    // Fields

    private String username;
    private String password;
    private Role role;

    public enum Role {
        ROLE_APP_USER, ROLE_APP_ADMIN
    }

    public AppUser(String username, String password, Role role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.role = role;
    }

    // Override toString() method to exclude password
    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    // Override hashCode() and equals() methods to exclude password
    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AppUser appUser = (AppUser) obj;
        return Objects.equals(username, appUser.username) &&
                role == appUser.role;
    }


}
