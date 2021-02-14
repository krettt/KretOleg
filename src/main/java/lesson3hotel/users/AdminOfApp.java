package main.java.lesson3hotel.users;


import main.java.lesson3hotel.DataSource;
import main.java.lesson3hotel.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class AdminOfApp extends User {

    List<User> managers = List.of(new Manager("Oleh","Kret"),new Manager("Ihor","Byluk")
            ,new Manager("Olena","Kit"),new Manager("July","Bodnar"));



    public AdminOfApp(String name, String surname) {
        super(name, surname);
    }


    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public void doWork() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel("Hilton Lviv",10, managers.get(0));
        hotel1.setCountOfRestaurants(2);
        hotel1.setSpaCenter(true);
        hotel1.setParkPlaceNearby(true);
        hotels.add(hotel1);


        Hotel hotel2 = new Hotel("Rixos Lviv",6, managers.get(1));
        hotel2.setCountOfRestaurants(3);
        hotel2.setSpaCenter(true);
        hotel2.setGum(true);
        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Radisson Bukovel",120, managers.get(2));
        hotel3.setCountOfRestaurants(2);
        hotel3.setCountOfSwimmingPools(2);
        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Rixos Kiev",23, managers.get(1));
        hotel4.setCountOfRestaurants(1);
        hotel4.setCountOfSwimmingPools(1);
        hotel4.setGum(true);
        hotels.add(hotel4);

        Hotel hotel5 = new Hotel("Plaza Kiev",30, managers.get(3));
        hotel5.setOwnBeach(true);
        hotel5.setSpaCenter(true);
        hotel5.setParkPlaceNearby(true);
        hotels.add(hotel5);


        DataSource.setHotels(this, hotels);

        managers.forEach(User::doWork);
    }
}
