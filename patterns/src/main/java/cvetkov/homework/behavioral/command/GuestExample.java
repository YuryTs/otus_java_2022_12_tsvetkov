package cvetkov.homework.behavioral.command;

import cvetkov.homework.behavioral.command.data.Guest;

public class GuestExample {
    public static void main(String[] args) {
        Guest guest = new Guest("Yurii Cvetkov");
        Booking booking = new Booking(guest); //это объект который хранит и команды и нашего гостя

        booking.addComand(new Room());
        booking.addComand(new ExtraBed());

        guest = booking.checkOut();

        System.out.printf("Информация по постояльцу: %s", guest);

    }
}
