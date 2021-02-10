package main.java.lesson3hotel.pageOfApp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {


    String Name;
    String Surname;
    boolean bool=true;

    public void outIntroduction(){
        System.out.println("Hello dear Wanderer.\n " +
                "Welcome into new program which help you booking hotel of your dream.\n" +
                "Follow the simple instructions of the program and you will get what you want.\n" +
                "Enjoy!");
    }

    public String inputName () {


        while (bool) {
            System.out.println("Please input your name (exemp.Oleh): ");
            Scanner scan = new Scanner(System.in);
            Name = scan.nextLine();

            boolean b= checkNameAndSurname(Name);

            if (b){
                bool=false;}
           else
                System.out.println("Invalid Name");


        }
        bool=true;
        return Name;
    }

    public String inputSurname () {
            while (bool) {
            System.out.println("Please input your surname (exemp.Kret): ");
            Scanner scan = new Scanner(System.in);
            Surname = scan.nextLine();

                   boolean b= checkNameAndSurname(Surname);
                    if (b){
                    bool=false;}
                else
                    System.out.println("Invalid Surname");

            }

            return Surname;
        }

        public boolean checkNameAndSurname (String input){
            Pattern p = Pattern.compile("[A-zА-я][a-zа-я]+");
            Matcher m = p.matcher(input);
            boolean b = m.matches();
            return b;

    }
}

