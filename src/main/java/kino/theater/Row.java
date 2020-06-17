package kino.theater;

import java.util.*;

//Entity
public class Row {

    private ArrayList<Seat> seats;
    private String rowName;
    private int seatCount;




        public Row(String rowName, int seatCount) {
            this.rowName = rowName;
            this.seatCount = seatCount;
            seats = new ArrayList<Seat>();
            createSeats(this.seatCount);
        }

    public void createSeats(int seatCount) {
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i, new ReserveStatus(false)));
        }
    }

    public int freeSeatsInARow() {
        int freeSeats = 0;
        for (Seat s : seats) {
            if (s.isReserved.equals(new ReserveStatus(false))) {
                freeSeats++;
            }
        }
        return freeSeats;
    }

    public int reserveSeats(int orderedSeats, int alreadyReserved) {

        for (Seat s : seats) {
            if (alreadyReserved < orderedSeats && s.isReserved.equals(new ReserveStatus(false))) {
                s.reserve();
                alreadyReserved++;
            }
        }
        return alreadyReserved;
    }

    public int unReserveSeats(int orderedSeats, int alreadyUnReserved) {
        for (Seat s : seats) {
            if (alreadyUnReserved < orderedSeats && s.isReserved.equals(new ReserveStatus(true))) {
                s.unreserve();
                alreadyUnReserved++;
            }
        }
        return alreadyUnReserved;
    }
}
