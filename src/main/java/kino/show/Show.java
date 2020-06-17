package kino.show;


import kino.database.CurrentDB;
import kino.theater.Theatre;

import java.util.Objects;
import java.util.UUID;

//Aggregat
public class Show implements ShowReposetory{
    private final Theatre theatre;
    public final Timeslot timeslot;
    public final MovieTitle movieTitle;
    private final FreeSeats freeSeats;
    //private final int showID ;
    private final UUID id = UUID.randomUUID();


    public  Show(Theatre theatre, Timeslot timeslot, MovieTitle movie) {
        this.theatre = theatre;
        this.timeslot = timeslot;
        this.movieTitle = movie;
        this.freeSeats = clacFreeSeats();
    }

    public  Show(Theatre theatre, Timeslot timeslot, MovieTitle movie,FreeSeats freeSeats) {
        this.theatre = theatre;
        this.timeslot = timeslot;
        this.movieTitle = movie;
        this.freeSeats = freeSeats;
    }

    public static Timeslot createTimeslot(String timeslotName, String time) {
        return new Timeslot(new TimeSlotName(timeslotName), new Time(time));
    }

    public int getFreeSeatsForMovie(){
        return freeSeats.getFreeSeats();
    }

    public Show bookShow(int orderedSeats){
        return new Show(theatre,timeslot,movieTitle,new FreeSeats(freeSeats.getFreeSeats()-orderedSeats));
    }

    public FreeSeats clacFreeSeats(){
        return theatre.getFreeSeatsInTheatre();
    }

    public void reserveSeats(int orderedSeats) {
        theatre.reserveSeats(orderedSeats);
    }

    public void unReserveSeats(int orderedSeats) {
        this.theatre.unReserveSeats(orderedSeats);
    }

    @Override
    public void save(Show show) {

    }

    @Override
    public Show findByID(String id) {
       // return CurrentDB.shows(id);
        return null;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Show show = (Show) o;
        return id.equals(show.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
