package main.java.lesson3hotel.hotel.room;

import main.java.lesson3hotel.users.User;
import main.java.lesson3hotel.users.Role;

public class Room {
    private TypeOfRoom type;
    private int countOfPeople;
    private int cost;
    private int size;

    public void setType(User user,TypeOfRoom typeOfRoom) {
        if(user.getRole()== Role.MANAGER)
            this.type = typeOfRoom;
        else System.out.println("User should has role as manager!");
    }


    public void setCountOfPeople(User user, int countOfPeople) {
        if(user.getRole()== Role.MANAGER)
        this.countOfPeople = countOfPeople;
    }

    public void setCost(User user, int cost) {
        if(user.getRole()== Role.MANAGER)
        this.cost = cost;
    }

    public void setSize(User user,int size) {
        if(user.getRole()== Role.MANAGER)
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public TypeOfRoom getType() {
        return type;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }


    public int getSize() {
        return size;
    }
}
