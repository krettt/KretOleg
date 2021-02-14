package main.java.lesson3hotel.hotel;


import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.hotel.room.TypeOfRoom;
import main.java.lesson3hotel.users.Role;
import main.java.lesson3hotel.users.User;

import java.util.*;

public class Hotel {
    private List<Room> rooms;
    private User manager;
    private final String name;
    private int countOfSwimmingPools;
    private int countOfRestaurants;
    private boolean ownBeach;
    private boolean spaCenter;
    private final int distanceFromAirport;
    private boolean gum;
    private boolean parkPlaceNearby;

    public Hotel(String name, int distanceFromAirport, User user) {
        this.name = name;
        this.distanceFromAirport = distanceFromAirport;
        if (user.getRole() == Role.MANAGER) {
            this.manager = user;
        } else System.out.println("User should has role as manager!");
    }
    public void getAllInfo(){
        System.out.println(getName()+" is located "+distanceFromAirport+" km from airport!\n"+
                getName()+" have : "+
                "\nRestaurants - "+countOfRestaurants +
                "\nSwimming pool - "+countOfSwimmingPools+
                "\nHave SpaCenter - "+spaCenter+
                "\nHave Own Beach - "+ownBeach+
                "\nOwn Gum - "+gum+
                "\nHave Park nearby - "+parkPlaceNearby);
    }


    public void setRoom(User user, List<Room> room) {
        if (user == manager) {
            this.rooms = room;
        } else System.out.println("Sorry only manager can set room!");
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getRooms(int countOfPeople, TypeOfRoom type) {
        List<Room> filteredRoom = new ArrayList<>();
        for (Room room : rooms) {
            if (countOfPeople <= room.getCountOfPeople() && type == room.getType()) {
                filteredRoom.add(room);
            }
        }
        return filteredRoom;
    }

    public void setCountOfSwimmingPools(int countOfSwimmingPools) {
        this.countOfSwimmingPools = countOfSwimmingPools;
    }

    public void setCountOfRestaurants(int countOfRestaurants) {
        this.countOfRestaurants = countOfRestaurants;
    }

    public void setOwnBeach(boolean ownBeach) {
        this.ownBeach = ownBeach;
    }

    public void setSpaCenter(boolean spaCenter) {
        this.spaCenter = spaCenter;
    }

    public void setGum(boolean gum) {
        this.gum = gum;
    }

    public void setParkPlaceNearby(boolean parkPlaceNearby) {
        this.parkPlaceNearby = parkPlaceNearby;
    }

    public User getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }


    public int getCountOfSwimmingPools() {
        return countOfSwimmingPools;
    }

    public int getCountOfRestaurants() {
        return countOfRestaurants;
    }

    public boolean isOwnBeach() {
        return ownBeach;
    }

    public boolean isSpaCenter() {
        return spaCenter;
    }

    public int getDistanceFromAirport() {
        return distanceFromAirport;
    }

    public boolean isGum() {
        return gum;
    }

    public boolean isParkPlaceNearby() {
        return parkPlaceNearby;
    }
}
