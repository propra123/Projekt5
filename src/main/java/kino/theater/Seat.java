package kino.theater;


// Entity
public class Seat {

    private final int seatNumber;

     ReserveStatus isReserved;

    public Seat(int seatNumber, ReserveStatus isReserved) {
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }

    public void reserve() {
        isReserved = new ReserveStatus(true);
    }

    public void unreserve() {
        isReserved = new ReserveStatus(false);
    }

}
