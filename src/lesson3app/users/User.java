package lesson3app.users;

import lesson3app.hotel.Hotel;

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

