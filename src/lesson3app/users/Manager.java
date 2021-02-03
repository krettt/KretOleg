package lesson3app.users;


import lesson3app.DataSource;
import lesson3app.hotel.Hotel;

import java.util.Random;

public class Manager extends User {


    public Manager(String name, String surname) {
        super(name, surname);
    }

    @Override
    public  Role getRole() {
        return Role.MANAGER;
    }

    @Override
    public void doWork() {
        for (Hotel hotel: DataSource.getHotels()) {
            if (hotel.getManager() == this) {
                hotel.setCost(this, new Random().nextInt(100));
            }
        }
    }
}
