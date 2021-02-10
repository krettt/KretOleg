package main.java.lesson3hotel.users;

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

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }


}
