package main.java.lesson3hotel.pageOfApp;

import main.java.lesson3hotel.DataSource;
import main.java.lesson3hotel.hotel.Hotel;
import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.hotel.room.TypeOfRoom;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Booking {

    boolean b = true;
    int number;
    Hotel chosenHotel;
    Room chosenRoom;
    TypeOfRoom typeOfRoom;


    public void setCountOfPeople() {
        System.out.println("Please choice count of people !(Select from 1 to 4): ");
        while (b) {
            Scanner scanner = new Scanner(System.in);
            String count = scanner.nextLine();

            number = Integer.parseInt(count);

            if (number <= 0) {
                System.out.println("Sorry but count of person must be more than zero!\n" +
                        "Please input one more time!");
                b = true;
            } else if (number > 4) {
                System.out.println("Sorry but  hotel has rooms for 1,2,3 or 4 person! \n" +
                        "Please input one more time");
                b = true;
            } else b = false;
        }
    }

    public void setDate() {
        System.out.println("Please choice months when you want booked hotel.");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String months = scan.nextLine().toUpperCase(Locale.ROOT);
            try {
                Months monthsEnum = Months.valueOf(months);
                System.out.println("Your choice " + monthsEnum);
                break;
            } catch (Exception e) {
                System.out.println("Invalid data. Enter again");
            }
        }
        System.out.println("Thanks, successfully saved");
    }

    public Hotel choseHotel() {
        chosenHotel = null;
        System.out.println("Please choice hotel from hotel's list:");
        for (Hotel hotel : DataSource.getHotels()) {
            System.out.println(hotel.getName());
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String hotelName = scan.nextLine().toUpperCase(Locale.ROOT);
            for (Hotel hotel : DataSource.getHotels()) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    chosenHotel = hotel;
                    break;
                }
            }

            if (chosenHotel == null) {
                System.out.println("Sorry try again");
            } else {
                System.out.println("Your choice " + chosenHotel.getName());
                break;
            }
        }
        System.out.println("Thanks, successfully saved");
        return chosenHotel;
    }

    public TypeOfRoom choseTypeOfRoom() {
        System.out.println("Please choice type of  list " + Arrays.toString(TypeOfRoom.values()) + " : ");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String type = scan.nextLine().toUpperCase(Locale.ROOT);
            try {
                typeOfRoom = TypeOfRoom.valueOf(type);
                System.out.println("Your choice " + typeOfRoom);
                break;
            } catch (Exception e) {
                System.out.println("Invalid type. Enter again");
            }
        }
        System.out.println("Thanks, successfully saved");
        return typeOfRoom;
    }


    public Room choseRoom() {
        chosenRoom = null;
        List<Room> filteredRoom = chosenHotel.getRooms(number, typeOfRoom);
        System.out.println("Please choice room from room's list ");
        for (int i =0; i < filteredRoom.size(); i++) {
            Room room = filteredRoom.get(i);
            System.out.println(i+1 + ") " + room.getType() + " - " + room.getCountOfPeople() + " :(price) " + room.getCost());
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String roomString = scan.nextLine();

            try{
                int roomNumber = Integer.parseInt(roomString)-1;
                chosenRoom=filteredRoom.get(roomNumber);
                System.out.println("Your choice " + chosenRoom.getType()+" for "+ chosenRoom.getCountOfPeople()
                        +" person. It cost: " +chosenRoom.getCost());
            }catch (IllegalArgumentException e){
                System.out.println("Invalid input. Enter again");
            }
        System.out.println("Thanks, successfully saved");
            return chosenRoom;
        }
    }

    public int getCost() {
        return chosenRoom.getCost();
    }

    public int getNumber() {
        return number;
    }

    public Hotel getChosenHotel() {
        return chosenHotel;
    }

    public Room getChosenRoom() {
        return chosenRoom;
    }

    public TypeOfRoom getTypeOfRoom() {
        return typeOfRoom;
    }
}
