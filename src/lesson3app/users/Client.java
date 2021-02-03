package lesson3app.users;

public class Client extends User{
    public Client(String name, String surname) {
        super(name, surname);
    }

    @Override
    public Role getRole() {
        return Role.CLIENT;
    }

    @Override
    public void doWork() {

    }
}
