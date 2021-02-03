package lesson3app.hotel;


import lesson3app.users.Role;
import lesson3app.users.User;

public class Hotel {


    private User manager ;
    private String name;
    private String location;
    private int cost;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void setManager(User user) {
        if(user.getRole()== Role.MANAGER)
        this.manager = user;
        else System.out.println("User should has role as manager!");
    }

    public void setCost(User user, int cost) {
        if(user == manager)
        this.cost = cost;
        else System.out.println("Sorry");
    }

    public User getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
