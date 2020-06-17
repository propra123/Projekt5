package kino.theater;

import kino.database.Database;
import kino.show.FreeSeats;
import java.util.*;

//Aggregat
public class Theatre implements TheatreReposetory {

    private final int theatreNumber;
    private final ArrayList<Row> rows;
    private final UUID id = UUID.randomUUID();

    public Theatre(int theatreNumber) {
        this.theatreNumber = theatreNumber;
        rows = new ArrayList<Row>();
    }

    public int getTheatreNumber() {
        return theatreNumber;
    }

    public FreeSeats getFreeSeatsInTheatre() {
        int freeSeats = 0;
        for (Row r : rows) {
            freeSeats += r.freeSeatsInARow();
        }
        return new FreeSeats(freeSeats);
    }

    public void reserveSeats(int orderedSeats) {
        int alreadyReserved = 0;
        for (Row r : rows) {
            if (alreadyReserved < orderedSeats) {
                alreadyReserved += r.reserveSeats(orderedSeats, alreadyReserved);
            }
        }
    }

    public void unReserveSeats(int orderedSeats) {
        int alreadyUnReserved = 0;

        for (Row r : rows) {
            if (alreadyUnReserved < orderedSeats) {
                alreadyUnReserved += r.unReserveSeats(orderedSeats, alreadyUnReserved);
            }
        }
    }

    @Override
    public void save(Theatre theatre, Database db) {
        db.saveTheatre(theatre);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Theatre theatre = (Theatre) o;
        return getId() == theatre.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // Testdaten anlegen
    public void addRow(String rowName, int seatCount) {
        rows.add(new Row(rowName, seatCount));
    }
}
