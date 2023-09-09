package cvetkov.homework.behavioral.command;

import cvetkov.homework.behavioral.command.data.Guest;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final List<Command> commandList = new ArrayList<>();

    private Guest guest;

    public Booking(Guest guest) {
        this.guest = guest;
    }
    public void addComand(Command command){
        commandList.add(command);
    }
    public Guest checkOut(){
        commandList.forEach(command -> command.execute(guest));
        return guest;
    }
}
