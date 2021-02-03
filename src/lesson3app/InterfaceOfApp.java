package lesson3app;

import lesson3app.hotel.Hotel;
import lesson3app.pageOfApp.Booking;
import lesson3app.pageOfApp.Payment;
import lesson3app.pageOfApp.Registration;
import lesson3app.users.AdminOfApp;
import lesson3app.users.Client;

public class InterfaceOfApp {

    public static void main(String[] args) {
        AdminOfApp admin = new AdminOfApp("Sasha", "S");
        admin.doWork();

        getRegister();
        Booking booking = getHotel();
        getPayment(booking);

    }

    private static Client getRegister() {
        Registration regist = new Registration();
        regist.outIntroduction();
        String name = regist.inputName();
        String surname = regist.inputSurname();
        return new Client(name,surname);
    }

    private static Payment getPayment(Booking booking) {
        Payment payment = new Payment();
        payment.outIntroductionOfPayment();
        payment.setWallet();
        payment.getPay(booking.getCost());
        return payment;
    }

    private static Booking getHotel() {
        Booking hotel = new Booking();
        hotel.setCountOfPeople();
        hotel.setDate();
        hotel.setHotel();
        return hotel;
    }
}
