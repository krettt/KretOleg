package lesson3app;

import lesson3app.hotel.Hotel;
import lesson3app.users.Role;
import lesson3app.users.User;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    static List<Hotel> hotels = new ArrayList<>();

    public static void setHotels(User user, List<Hotel> listOfhotels) {
        if(user.getRole()== Role.ADMIN)
        hotels = listOfhotels;
        else System.out.println("Sorry ");
    }

    public static List<Hotel> getHotels() {
        return hotels;
    }
}
