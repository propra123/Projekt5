package kino.database;

import kino.booking.Booking;
import kino.show.MovieTitle;
import kino.show.Show;
import kino.theater.Theatre;
import kino.theater.TheatreReposetory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CurrentDB implements Database {
    private final Map<String, Theatre> theaters = new HashMap<>();
    private final Map<String, Show> shows = new HashMap<>();
   private final Map<String, Booking> bookings = new HashMap<>();
    private final UUID id = UUID.randomUUID();




    @Override
    public Theatre theatre(String theatreNuber) {
        return theaters.get(theatreNuber);
    }
    @Override
    public Show shows(String showNumber) {
        return shows.get(showNumber);
    }

    public void createShowDB(Theatre theatre) {
        Show firstShow = new Show(theatre, Show.createTimeslot("Timeslot B", "21:00"), new MovieTitle("Film 1"));
        Show secondShow = new Show(theatre, Show.createTimeslot("Timeslot B", "21:00"), new MovieTitle("Film 1"));
        Show thirdShow = new Show(theatre, Show.createTimeslot("Timeslot c", "24:00"), new MovieTitle("Film 1"));
        shows.put("1", firstShow);
        shows.put("2", secondShow);
        shows.put("3", thirdShow);
    }

    public void createTheatreDB() {
        //TheatreReposetory firstTheater = new Theatre(1);
        Theatre firstTheater = new Theatre(1);
        firstTheater.addRow("A", 7);
        firstTheater.addRow("B", 15);
        firstTheater.addRow("C", 15);
        firstTheater.addRow("D", 15);
        firstTheater.addRow("E", 20);
        firstTheater.addRow("F", 5);
        theaters.put("1", firstTheater);
        Theatre secondTheatre = new Theatre(2);
        firstTheater.addRow("A", 50);
        firstTheater.addRow("B", 50);
        firstTheater.addRow("D", 50);
        firstTheater.addRow("F", 2);
        theaters.put("2", secondTheatre);
    }


    @Override
   public void saveTheatre(Theatre theatre){
        theaters.put((Integer.toString(theatre.getTheatreNumber())),theatre);
    }

    @Override
    public void saveShow(Show show) {
        shows.put("2",show);
    }

    @Override
    public void saveBooking(Booking booking) {
        bookings.put("",booking);
    }


}
