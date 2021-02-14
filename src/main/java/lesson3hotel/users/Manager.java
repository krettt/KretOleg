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
        DataSource.getHotels().stream().filter(hotel -> hotel.getManager() == this).forEach(hotel -> {
            ArrayList<Room> rooms = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Room room1 = new Room();
                room1.setType(this, TypeOfRoom.STANDARD);
                room1.setSize(this,new Random().nextInt(10)+20);
                room1.setCountOfPeople(this, j + 1);
                room1.setCost(this, new Random().nextInt(30)*(j+1)+20);
                rooms.add(room1);

                Room room2 = new Room();
                room2.setType(this, TypeOfRoom.SUITE);
                room2.setSize(this,new Random().nextInt(40)+20);
                room2.setCountOfPeople(this, j + 1);
                room2.setCost(this, new Random().nextInt(55)*(j+1)+20);
                rooms.add(room2);

                Room room = new Room();
                room.setType(this, TypeOfRoom.LUXURY);
                room.setSize(this,new Random().nextInt(60)+20);
                room.setCountOfPeople(this, j + 1);
                room.setCost(this, new Random().nextInt(80)*(j+1)+20);
                rooms.add(room);
            }
            hotel.setRoom(this, rooms);
        });
    }
}
