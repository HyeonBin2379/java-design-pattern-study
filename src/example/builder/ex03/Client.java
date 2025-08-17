package example.builder.ex03;

import java.time.LocalDate;

public class Client {

    private Builder builder;

    public Client(Builder builder) {
        this.builder = builder;
    }

    public void constructPlanner() {
        String date = LocalDate.now().toString();

        builder.buildDay(date);
        builder.addHotel(date, "Grand Facadian");
        builder.addTickets("Patterns on Ice");

        Planner yourPlanner = builder.getVacationPlanner();
        System.out.println(yourPlanner);
    }
}
