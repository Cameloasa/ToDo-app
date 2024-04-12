package se.lexicon.model;

import se.lexicon.data.sequencer.PersonIdSequencer;

import java.util.Objects;

public class Person {
    // Fields


    private int id;
    private String firstName; // not allowed to be null
    private String lastName; // not allowed to be null
    private String email; // not allowed to be null
    private AppUser credentials; // Reference to AppUser

    //Constructors
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    //Setters
    public void setFirstName(String firstName) {
        if(firstName == null) throw new IllegalArgumentException("This field should not be nul");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {if(firstName == null) throw new IllegalArgumentException("This field should not be nul");
        if(lastName == null) throw new IllegalArgumentException("This field should not be nul");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(email == null) throw new IllegalArgumentException("This field should not be nul");
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Credentials

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    //Override methods for ToString, Equals and HashCode
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, email);
    }




}
