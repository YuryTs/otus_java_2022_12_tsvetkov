package cvetkov.homework.behavioral.command;

import cvetkov.homework.behavioral.command.data.Guest;

public interface Command {
     void execute(Guest guest);
}
