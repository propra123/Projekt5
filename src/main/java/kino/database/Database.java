package kino.database;

import kino.booking.Booking;
import kino.show.Show;
import kino.theater.Theatre;

public interface Database {


    Theatre theatre(String theatreNubmber);

    Show shows(String showNumber);

    void saveTheatre(Theatre theatre);

    void saveShow(Show show);

    void saveBooking(Booking booking) ;


}
