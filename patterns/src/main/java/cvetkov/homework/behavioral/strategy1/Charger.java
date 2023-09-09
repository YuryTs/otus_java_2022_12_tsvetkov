package cvetkov.homework.behavioral.strategy1;

import cvetkov.homework.behavioral.command.*;
import cvetkov.homework.behavioral.command.data.Guest;

public class Charger {
    public enum Charges {

        EXTRABED(new ExtraBed()),
        ROOM(new Room());

        Charges(final Command command) {
            this.command = command;
        }

        final Command command;
    }

    public static void charge(Guest user, Charges type) {
        type.command.execute(user);
    }

}
