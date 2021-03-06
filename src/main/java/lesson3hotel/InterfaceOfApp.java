package main.java.lesson3hotel;

import main.java.lesson3hotel.pageOfApp.Booking;
import main.java.lesson3hotel.pageOfApp.Payment;
import main.java.lesson3hotel.pageOfApp.Registration;
import main.java.lesson3hotel.users.AdminOfApp;
import main.java.lesson3hotel.users.Client;

import java.lang.reflect.Method;


public class InterfaceOfApp {

    public static void main(String[] args) throws NoSuchMethodException {

        AdminOfApp admin = new AdminOfApp("Ilona", "Hodakova");
        admin.doWork();

        printAnnotationDetails("getRegister");
        Client client = getRegister();
        printAnnotationDetails("getBooking");
        Booking booking = getBooking();
        printAnnotationDetails("getPayment");
        Payment payment = getPayment(booking);

        printConfirmation(client, booking, payment);

    }

    public static void printAnnotationDetails(String methodName) throws NoSuchMethodException {
        Method method = InterfaceOfApp.class.getDeclaredMethod(methodName);
        Step step = method.getAnnotation(Step.class);
        System.out.println(step.value() + ") " + step.title() + " : " + step.description());

    }


    @Step(value = 1, title = "Registration", description = "In this step you can to register in App of booking hotel! ")
    private static Client getRegister() {
        Registration regist = new Registration();
        regist.outIntroduction();
        String name = regist.inputName();
        String surname = regist.inputSurname();
        return new Client(name, surname);
    }

    @Step(value = 2, title = "Booking", description = "In this step you can choice hotel and room!")
    private static Booking getBooking() {
        Booking booking = new Booking();
        booking.choseHotel();
        booking.sortedRoom();
        booking.setCountOfPeople();
        booking.setDate();
        booking.choseTypeOfRoom();
        booking.choseRoom();
        return booking;
    }

    @Step(value = 3, title = "Payment", description = "In this step you can payment your choice of room.")
    private static Payment getPayment(Booking booking) {
        Payment payment = new Payment();
        payment.outIntroductionOfPayment();
        payment.setWallet();
        payment.doPay(booking.getCost());
        return payment;
    }

    private static void printConfirmation(Client client, Booking booking, Payment payment) {
        System.out.println("Congratulations your booking is successfully saved!");
        System.out.println("Client : " + client.getName() + " " + client.getSurname()
                + "\nBooked Hotel : " + booking.getChosenHotel().getName() + "\nType : "
                + booking.getTypeOfRoom() + "\nFor: " + booking.getNumber() + " person.\nCost : "
                + booking.getCost() + "\nLeft on the wallet : " + payment.getWallet());
    }
}
