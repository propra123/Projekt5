package kino.booking;



import kino.customer.EmailAdress;
import kino.customer.Name;
import kino.database.CurrentDB;
import kino.database.Database;
import kino.show.Show;
import kino.customer.Customer;


public class Booking implements BookingReposetory {
    Customer customer;
    private final Show show;
    private final int orderedSeats;
    private final ResNumber resNumber;

    public Booking(Show show, int orderedSeats) {
        this.show = show;
        this.orderedSeats = orderedSeats;
        this.resNumber = createResNumber();
    }

    private ResNumber createResNumber() {
        return new ResNumber();
    }

    public static Booking create(Show show, int orderedSeats) {
        if (orderedSeats < show.getFreeSeatsForMovie()) {
            Show s = show.bookShow(orderedSeats);
            s.reserveSeats(orderedSeats);
            return new Booking( s, orderedSeats);
        } else {
            System.out.println("Es sind keine " + orderedSeats + " freien Plätze mehr vorhanden");
            return new Booking( null, orderedSeats);
        }
    }

    public void confirm(String vorname, String nachname, String email) {
        Customer customer = createCustomer(vorname, nachname, email);
        ausgabe(customer, resNumber);
    }

    public Customer createCustomer(String vorname, String nachname, String email) {
        return new Customer(new Name(vorname, nachname), new EmailAdress(email));
    }

    public void decline() {
        show.unReserveSeats(orderedSeats);
    }

    public void ausgabe(Customer customer, ResNumber resNumber) {
        System.out.println("Kunde: " + customer.getEmail() + "  Reservierungsnummer: " + resNumber.getResNumber());
    }

    @Override
    public void save(Booking booking) {
        Database db = new CurrentDB();
        db.saveBooking(booking);
    }
}
