package kino;

import kino.booking.Booking;
import kino.database.CurrentDB;


public class Kinoverwaltung {

    public static void main(String[] args) {

        // Test Daten anlegen
        CurrentDB db = new CurrentDB();
        db.createTheatreDB();
        db.createShowDB(db.theatre("1"));


        // Test Bookings

        System.out.println(db.shows("1").clacFreeSeats().getFreeSeats());

        Booking bk1 = Booking.create(db.shows("1"), 3);
        Booking bk2 = Booking.create(db.shows("1"), 5);
        System.out.println(db.shows("1").clacFreeSeats().getFreeSeats());
        Booking bk3 = Booking.create(db.shows("2"), 1);
        System.out.println(db.shows("2").clacFreeSeats().getFreeSeats());
        Booking bk4 = Booking.create(db.shows("1"), 2);


        bk1.confirm("Dennis", "Froelich", "email@provider.de");
        bk3.decline();
        bk2.confirm("Peter", "Lustig", "email2@provider.de");
        bk4.decline();
    }
}