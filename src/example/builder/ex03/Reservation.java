package example.builder.ex03;

public class Reservation {

    private String date;
    private String client;

    public Reservation(String date, String client) {
        this.date = date;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "date='" + date + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
