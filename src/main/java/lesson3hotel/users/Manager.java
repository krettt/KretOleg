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
    public  Role getRole() {
        return Role.MANAGER;
    }

    @Override
    public void doWork() {
        for (Hotel hotel: DataSource.getHotels()) {
            if (hotel.getManager() == this) {
                ArrayList<Room> rooms = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    Room room = new Room();
                    room.setType(this, TypeOfRoom.LUXURY);
                    room.setCountOfPeople(this, j + 1);
                    room.setCost(this, new Random().nextInt(100)*j+1);
                    rooms.add(room);

                    Room room1 = new Room();
                    room1.setType(this, TypeOfRoom.STANDARD);
                    room1.setCountOfPeople(this, j + 1);
                    room1.setCost(this, new Random().nextInt(50)*j+1);
                    rooms.add(room1);
                }
                hotel.setRoom(this, rooms);
            }
        }
    }
}
