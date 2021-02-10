package main.java.lesson3hotel;

import main.java.lesson3hotel.hotel.Hotel;
import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.users.Role;
import main.java.lesson3hotel.users.User;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    static List<Hotel> hotels = new ArrayList<>();
//    static List<Room> rooms = new ArrayList<>();

    public static void setHotels(User user, List<Hotel> listOfhotels) {
        if(user.getRole()== Role.ADMIN)
        hotels = listOfhotels;
        else System.out.println("Sorry,only admin can set hotel in list!");
    }
//    public static void setRoom(User user,List<Room>listOfRooms) {
//        if(user.getRole()== Role.MANAGER)
//            rooms = listOfRooms;
//        else System.out.println("Sorry,only manager can set hotel in list!");
//    }

    public static List<Hotel> getHotels() {
        return hotels;
    }
//    public static List<Room> getRoomsForHotel(Hotel hotel){ return rooms; }
}
