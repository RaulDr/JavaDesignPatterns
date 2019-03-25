package DesignPatterns.Factories;

import java.util.ArrayList;
import java.util.List;


interface House{
    void addFurniture(Furniture furniture);
}

interface Furniture{
}

class Door{
}

class Table{
    private int noLegs;

    public Table(final int noLegs) {
        this.noLegs = noLegs;
    }

    public int getNoLegs() {
        return noLegs;
    }

    public void setNoLegs(final int noLegs) {
        this.noLegs = noLegs;
    }

    @Override
    public String toString() {
        return "Table{" +
                "noLegs=" + noLegs +
                '}';
    }
}

class Bad implements Furniture{

}

class Room implements House{

    private List<Furniture> furniture = new ArrayList<>();
    private Door door;
    private Table table;

    @Override
    public void addFurniture(final Furniture furniture) {

    }

    public int getNumberTableLegs(){
        return table.getNoLegs();
    }

    public List<Furniture> getHouseStaff() {
        return furniture;
    }

    public void setHouseStaff(final List<Furniture> houseStaff) {
        this.furniture = houseStaff;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(final Door door) {
        this.door = door;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(final Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Room{" +
                "furniture=" + furniture +
                ", door=" + door +
                ", table=" + table +
                '}';
    }
}

public class Demo {
    public static void main(String[] args) {
        Room room = new Room();
        Furniture furniture = new Bad();
        Table table = new Table(3);
        Door door = new Door();
        room.setDoor(door);
        room.setTable(table);
        room.addFurniture(furniture);
        System.out.println(room);
    }
}
