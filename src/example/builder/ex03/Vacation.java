package example.builder.ex03;

public class Vacation {

    private String date;
    private Hotel hotel;
    private Ticket ticket;
    private Reservation reservation;
    private SpecialEvent specialEvent;

    public Vacation(String date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setSpecialEvent(SpecialEvent specialEvent) {
        this.specialEvent = specialEvent;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "date='" + date + '\'' +
                ", hotel=" + hotel +
                ", ticket=" + ticket +
                ", reservation=" + reservation +
                ", specialEvent=" + specialEvent +
                '}';
    }
}
