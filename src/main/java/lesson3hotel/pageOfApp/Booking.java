package main.java.lesson3hotel.pageOfApp;

import main.java.lesson3hotel.DataSource;
import main.java.lesson3hotel.hotel.Hotel;
import main.java.lesson3hotel.hotel.room.Room;
import main.java.lesson3hotel.hotel.room.TypeOfRoom;

import java.util.*;

public class Booking {

    boolean b = true;
    int number;
    Hotel chosenHotel;
    Room chosenRoom;
    TypeOfRoom typeOfRoom;


    public void setCountOfPeople() {
        System.out.println("---------------------------");
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
        System.out.println("---------------------------");
        System.out.println("Please choice months when you want booked hotel " + Arrays.toString(Months.values()) + " :");
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

    public void sortedRoom() {
        System.out.println("---------------------------");
        System.out.println("All list of rooms in " + chosenHotel + " :");
        chosenHotel.getRooms().forEach(x -> System.out.println("\tCost of room: " + x.getCost() + "\tSize of room: " + x.getSize() +
                "\tPerson capacity: " + x.getCountOfPeople() + "\tType of room: " + x.getType()));

        System.out.println("---------------------------");
        System.out.println("You can sorted room's by some criterion:\n 1)type\n 2)cost\n 3)size\n 4)count of people ");

        SortedType sortedType;
        while (true) {
            Scanner scan = new Scanner(System.in);
            String sortedInput = scan.nextLine().toUpperCase(Locale.ROOT);
            try {
                sortedType = SortedType.valueOf(sortedInput);
                break;
            } catch (Exception e) {
                System.out.println("Invalid type");
            }
        }
        Comparator<Room> comparator;
        switch (sortedType) {
            case TYPE -> comparator = Comparator.comparing(Room::getType);
            case COST -> comparator = Comparator.comparing(Room::getCost);
            case SIZE -> comparator = Comparator.comparing(Room::getSize);
            case COUNT -> comparator = Comparator.comparing(Room::getCountOfPeople);
            default -> comparator = Comparator.comparing(Room::getType);
        }
        chosenHotel.getRooms().stream().sorted(comparator).forEach(x -> System.out.println("\tCost of room: " + x.getCost() + "\tSize of room: " +
                x.getSize() + "\tPerson capacity: " + x.getCountOfPeople() + "\tType of room: " + x.getType()));

    }

    public void choseHotel() {
        chosenHotel = null;
        System.out.println("---------------------------");
        System.out.println("Please choice hotel from hotel's list:");
        DataSource.getHotels().forEach(hotel -> System.out.println(hotel.getName()));
        while (true) {
            Scanner scan = new Scanner(System.in);
            String hotelName = scan.nextLine().toUpperCase(Locale.ROOT);
            Optional<Hotel> filteredHotel = DataSource.getHotels().stream().filter(hotel -> hotel.getName().equalsIgnoreCase(hotelName))
                    .findFirst();

            if (filteredHotel.isPresent()) {
                System.out.println("Your choice " + filteredHotel.get().getName());
                chosenHotel = filteredHotel.get();
                break;
            } else System.out.println("Incorrect choice, type again ");
        }
        System.out.println("Thanks, successfully saved." +
                "\nYour choice is :" + chosenHotel + ". Info about this hotel:");
        chosenHotel.getAllInfo();
    }

    public void choseTypeOfRoom() {
        System.out.println("---------------------------");
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
    }


    public void choseRoom() {
        chosenRoom = null;
        List<Room> filteredRoom = chosenHotel.getRooms(number, typeOfRoom);
        System.out.println("---------------------------");
        System.out.println("Please choice room from room's list ");
        for (int i = 0; i < filteredRoom.size(); i++) {
            Room room = filteredRoom.get(i);
            System.out.println(i + 1 + ") " + room.getType() + " - " + room.getCountOfPeople() + " :(price) " + room.getCost());
        }
        while (true) {
            Scanner scan = new Scanner(System.in);
            String roomString = scan.nextLine();

            try {
                int roomNumber = Integer.parseInt(roomString) - 1;
                chosenRoom = filteredRoom.get(roomNumber);
                System.out.println("Your choice " + chosenRoom.getType() + " for " + chosenRoom.getCountOfPeople()
                        + " person. It cost: " + chosenRoom.getCost());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Enter again");
            }
            System.out.println("Thanks, successfully saved");
            return;
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
