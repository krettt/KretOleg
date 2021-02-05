package main.java.lesson3hotel.pageOfApp;

import java.util.Scanner;

public class Payment {
    int wallet;
    int pay;
    boolean b=false;


    public void outIntroductionOfPayment() {
        System.out.println("Please deposit the amount into your appwallet.\n" +
                "You can use it to book");
    }

    public int setWallet() {
        Scanner scan = new Scanner(System.in);
        String wall = scan.nextLine();
        wallet = Integer.parseInt(wall);

        return wallet;
    }



    public  void doPay(int cost) {

        while (!b) {
            pay = wallet - cost ;

            if (pay >= 0) {
                b = true;
                wallet = pay;
            } else {
                b = false;
                System.out.println("I'm sorry, but you don't have enough money in your wallet\n" +
                        "Please top up the deposit!");
                setWallet();
            }
        }
        System.out.println("Congratulations.Hotel is booked!");
        System.out.println("You have now :"+ wallet +" in your deposit.");
    }

    public int getWallet() {
        return wallet;
    }
}
