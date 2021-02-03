package lesson3app.pageOfApp;

import lesson3app.DataSource;
import lesson3app.hotel.Hotel;

import java.util.Locale;
import java.util.Scanner;

public class Booking {

    boolean b = true;
    int number;
    Hotel choosenHotel;

    public void setCountOfPeople() {
        System.out.println("Please choice count of people !");
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

    public int getCost() {
       return number * choosenHotel.getCost();
    }

    public Hotel setHotel() {
        choosenHotel = null;
        System.out.println("Please choice hotel from hotel's list:");
        for (Hotel hotel : DataSource.getHotels()) {
            System.out.println(hotel.getName());
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String hotelName = scan.nextLine().toUpperCase(Locale.ROOT);
            for (Hotel hotel : DataSource.getHotels()) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    choosenHotel = hotel;
                    break;
                }
            }

            if (choosenHotel == null) {
                System.out.println("Sorry try again");
            } else {
                System.out.println("Your choice " + choosenHotel.getName());
                break;
            }
        }
        System.out.println("Thanks, successfully saved");
        return choosenHotel;
    }
}
