package kino.show;

import java.util.Objects;

//Werteobjekt
public class FreeSeats {
    private final int freeSeats;

    public FreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FreeSeats freeSeat = (FreeSeats) o;
        return freeSeats == freeSeat.freeSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freeSeats);
    }
}
