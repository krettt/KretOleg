package main.java.lesson3hotel.hotel.room;

import main.java.lesson3hotel.users.User;
import main.java.lesson3hotel.users.Role;

public class Room {
    private TypeOfRoom type;
    private int countOfPeople;
    private int cost;
    private int size;
    private boolean balcony;
    private boolean jacuzzi;
    private boolean livingRoom;
    private boolean safe;
    private boolean terrace;
    private boolean miniBar;


    public Room(User user,TypeOfRoom type, int countOfPeople, int cost, int size) {
        if(user.getRole()== Role.MANAGER) {
            this.type = type;
            this.countOfPeople = countOfPeople;
            this.cost = cost;
            this.size = size;
        }else System.out.println("User should has role as manager!");
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public void setLivingRoom(boolean livingRoom) {
        this.livingRoom = livingRoom;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public void setTerrace(boolean terrace) {
        this.terrace = terrace;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
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

    public boolean isBalcony() {
        return balcony;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public boolean isLivingRoom() {
        return livingRoom;
    }

    public boolean isSafe() {
        return safe;
    }

    public boolean isTerrace() {
        return terrace;
    }

    public boolean isMiniBar() {
        return miniBar;
    }
}
