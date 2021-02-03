package lesson3app.users;


import lesson3app.DataSource;
import lesson3app.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class AdminOfApp extends User {

    List<User> managers = List.of(new Manager("Oleh","Kret"),new Manager("Ihor","Byluk"));

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
        Hotel hotel1 = new Hotel("Hilton", "Lviv");
        hotel1.setManager(managers.get(0));
        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Rixys", "Lviv");
        hotel2.setManager(managers.get(1));
        hotels.add(hotel2);

        DataSource.setHotels(this, hotels);

        for (User manager: managers) {
            manager.doWork();
        }
    }
}
