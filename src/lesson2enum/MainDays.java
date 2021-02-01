package lesson2enum;

import java.util.Scanner;

public class MainDays {
    public static void main(String[] args) {

        System.out.println("Please input day of week : ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();

        WeekDays[] weekDays = WeekDays.values();


        switch (input) {
            case "MONDAY" -> {
                WeekDays monday = WeekDays.MONDAY;
                int i = monday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "TUESDAY" -> {
                WeekDays tuesday = WeekDays.TUESDAY;
                int i = tuesday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "WEDNESDAY" -> {
                WeekDays wednesday = WeekDays.WEDNESDAY;
                int i = wednesday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "THURSDAY" -> {
                WeekDays thursday = WeekDays.THURSDAY;
                int i = thursday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "FRIDAY" -> {
                WeekDays friday = WeekDays.FRIDAY;
                int i = friday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "SATURDAY" -> {
                WeekDays saturday = WeekDays.SATURDAY;
                int i = saturday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            case "SUNDAY" -> {
                WeekDays sunday = WeekDays.SUNDAY;
                int i = sunday.ordinal() + 1;
                System.out.println(weekDays[i]);
            }
            default -> System.out.println("Sorry but you must input only MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY ");

        }
    }
}



