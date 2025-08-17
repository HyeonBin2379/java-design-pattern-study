package example.builder.ex03;

public class Ticket {

    private String movieName;

    public Ticket(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                '}';
    }
}
