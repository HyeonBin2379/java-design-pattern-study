package example.builder.ex03;

public interface Builder {

    void buildDay(String date);
    void addHotel(String date, String name);
    void addReservation(String date, String name);
    void addSpecialEvent(String date, String name);
    void addTickets(String movieName);

    Planner getVacationPlanner();
}
