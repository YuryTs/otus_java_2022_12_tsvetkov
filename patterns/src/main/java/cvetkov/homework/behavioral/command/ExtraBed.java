package cvetkov.homework.behavioral.command;

import cvetkov.homework.behavioral.command.Command;
import cvetkov.homework.behavioral.command.data.Charge;
import cvetkov.homework.behavioral.command.data.Guest;

public class ExtraBed implements Command{

    @Override
    public void execute(Guest guest) {
        guest.addCharge(new Charge("Extra bed", 20));
    }
}
