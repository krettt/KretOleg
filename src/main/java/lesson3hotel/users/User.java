package main.java.lesson3hotel.users;

public abstract class User {
    String name;
    String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract Role getRole();

    public abstract void doWork();

}

