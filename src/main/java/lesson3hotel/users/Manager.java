package main.java.lesson3hotel.users;


import main.java.lesson3hotel.DataSource;
import main.java.lesson3hotel.hotel.Hotel;
import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.hotel.room.TypeOfRoom;

import java.util.ArrayList;
import java.util.Random;


public class Manager extends User {


    public Manager(String name, String surname) {
        super(name, surname);
    }

    @Override
    public Role getRole() {
        return Role.MANAGER;
    }

    @Override
    public void doWork() {
        DataSource.getHotels().stream().filter(hotel -> hotel.getManager() == this).forEach(hotel -> {
            ArrayList<Room> rooms = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Room room1 = new Room(this, TypeOfRoom.STANDARD, j + 1,
                        new Random().nextInt(30) * (j + 1) + 20,
                        new Random().nextInt(10) + 20);
                room1.setSafe(true);
                rooms.add(room1);

                Room room2 = new Room(this, TypeOfRoom.SUITE, j + 1,
                        new Random().nextInt(55) * (j + 1) + 20,
                        new Random().nextInt(40) + 20);
                room2.setBalcony(true);
                room2.setSafe(true);
                room2.setMiniBar(true);
                rooms.add(room2);

                Room room3 = new Room(this, TypeOfRoom.LUXURY, j + 1,
                        new Random().nextInt(80) * (j + 1) + 20,
                        new Random().nextInt(60) + 20);
                room3.setLivingRoom(true);
                room3.setJacuzzi(true);
                room3.setTerrace(true);
                room3.setMiniBar(true);
                room3.setSafe(true);
                rooms.add(room3);
            }
            hotel.setRoom(this, rooms);
        });
    }
}
