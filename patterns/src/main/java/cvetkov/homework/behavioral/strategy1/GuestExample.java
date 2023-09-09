package cvetkov.homework.behavioral.strategy1;

import cvetkov.homework.behavioral.command.data.Guest;

public class GuestExample {
    public static void main(String[] args) {
        Guest guest = new Guest("Ivan Ivanov");
        Charger.charge(guest, Charger.Charges.ROOM);
        Charger.charge(guest, Charger.Charges.EXTRABED);

        System.out.println(guest);
    }
}