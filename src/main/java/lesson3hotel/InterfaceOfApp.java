package main.java.lesson3hotel;

import main.java.lesson3hotel.pageOfApp.Booking;
import main.java.lesson3hotel.pageOfApp.Payment;
import main.java.lesson3hotel.pageOfApp.Registration;
import main.java.lesson3hotel.users.AdminOfApp;
import main.java.lesson3hotel.users.Client;

public class InterfaceOfApp {

    public static void main(String[] args) {

        AdminOfApp admin = new AdminOfApp("Ilona", "Hodakova");
        admin.doWork();

        Client client = getRegister();
        Booking booking = getBooking();
        Payment payment = getPayment(booking);

        printConfirmation(client,booking,payment);

    }

    private static Client getRegister() {
        Registration regist = new Registration();
        regist.outIntroduction();
        String name = regist.inputName();
        String surname = regist.inputSurname();
        return new Client(name, surname);
    }

    private static Payment getPayment(Booking booking) {
        Payment payment = new Payment();
        payment.outIntroductionOfPayment();
        payment.setWallet();
        payment.doPay(booking.getCost());
        return payment;
    }

    private static Booking getBooking() {
        Booking booking = new Booking();
        booking.setCountOfPeople();
        booking.setDate();
        booking.choseHotel();
        booking.choseTypeOfRoom();
        booking.choseRoom();
        return booking;
    }
    private static void printConfirmation(Client client,Booking booking,Payment payment){
        System.out.println("Congratulations your booking is successfully saved!");
        System.out.println("Client : "+client.getName()+" "+client.getSurname()
                + "\nBooked Hotel : "+ booking.getChosenHotel().getName()+"\nType : "
                +booking.getTypeOfRoom()+"\nFor: "+booking.getNumber()+" person.\nCost : "
                +booking.getCost() +"\nLeft on the wallet : "+payment.getWallet());
    }
}
