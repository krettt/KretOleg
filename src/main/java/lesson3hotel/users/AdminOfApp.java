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
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel("Hilton Lviv");
        hotel1.setManager(managers.get(0));
        hotels.add(hotel1);


        Hotel hotel2 = new Hotel("Rixos Lviv");
        hotel2.setManager(managers.get(1));
        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Radisson Bukovel");
        hotel3.setManager(managers.get(2));
        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Rixos Kiev");
        hotel4.setManager(managers.get(1));
        hotels.add(hotel4);

        Hotel hotel5 = new Hotel("Plaza Kiev");
        hotel5.setManager(managers.get(3));
        hotels.add(hotel5);


        DataSource.setHotels(this, hotels);

        for (User manager: managers) {
            manager.doWork();
        }
    }
}
