package main.java.lesson3hotel;

import main.java.lesson3hotel.pageOfApp.Booking;
import main.java.lesson3hotel.pageOfApp.Payment;
import main.java.lesson3hotel.pageOfApp.Registration;
import main.java.lesson3hotel.users.AdminOfApp;
import main.java.lesson3hotel.users.Client;

public class FacadeOfClientInterface {

    protected static void doWorkClientInterface()  {
        AdminOfApp admin = new AdminOfApp("Ilona", "Hodakova");
        admin.doWork();

        Client client = getRegister();
        Booking booking = getBooking();
        Payment payment = getPayment(booking);
        printConfirmation(client, booking, payment);
    }



    protected static Client getRegister() {
        Registration regist = new Registration();
        regist.outIntroduction();
        String name = regist.inputName();
        String surname = regist.inputSurname();
        return new Client(name, surname);
    }

   protected static Booking getBooking() {
        Booking booking = new Booking();
        booking.choseHotel();
        booking.sortedRoom();
        booking.setCountOfPeople();
        booking.setDate();
        booking.choseTypeOfRoom();
        booking.choseRoom();
        return booking;
    }

    protected static Payment getPayment(Booking booking) {
        Payment payment = new Payment();
        payment.outIntroductionOfPayment();
        payment.setWallet();
        payment.doPay(booking.getCost());
        return payment;
    }

    protected static void printConfirmation(Client client, Booking booking, Payment payment) {
        System.out.println("Congratulations your booking is successfully saved!");
        System.out.println("Client : " + client.getName() + " " + client.getSurname()
                + "\nBooked Hotel : " + booking.getChosenHotel().getName() + "\nType : "
                + booking.getTypeOfRoom() + "\nFor: " + booking.getNumber() + " person.\nCost : "
                + booking.getCost() + "\nLeft on the wallet : " + payment.getWallet());
    }
}
