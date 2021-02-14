package main.java.lesson3hotel.hotel;


import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.hotel.room.TypeOfRoom;
import main.java.lesson3hotel.users.Role;
import main.java.lesson3hotel.users.User;

import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private User manager ;
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public void setManager(User user) {
        if(user.getRole()== Role.MANAGER)
        this.manager = user;
        else System.out.println("User should has role as manager!");
    }


    public void setRoom(User user, List<Room>room) {
        if(user == manager) {
            this.rooms = room;
        }
        else System.out.println("Sorry only manager can set room!");
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getRooms(int countOfPeople, TypeOfRoom type) {
        List<Room> filteredRoom = new ArrayList<>();
        for(Room room: rooms){
            if(countOfPeople <= room.getCountOfPeople() && type == room.getType()) {
                filteredRoom.add(room);
            }
        }
        return filteredRoom;
    }

    public User getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

}
