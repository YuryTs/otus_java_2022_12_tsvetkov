package cvetkov.homework.behavioral.command;

import cvetkov.homework.behavioral.command.data.Guest;

public class Room implements Command{
    @Override
    public void execute(Guest guest) {
        guest.setRentCost(120);
    }
}
