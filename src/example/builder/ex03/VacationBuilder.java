package example.builder.ex03;

import exercise.singleton.TicketMakerMain;

public class VacationBuilder implements Builder {

    private Vacation vacation;

    @Override
    public void buildDay(String date) {
        this.vacation = new Vacation(date);
    }

    @Override
    public void addHotel(String date, String name) {
        System.out.println("VacationBuilder.addHotel");
        Hotel hotel = new Hotel(date, name);
        vacation.setHotel(hotel);
    }

    @Override
    public void addReservation(String date, String name) {
        System.out.println("VacationBuilder.addReservation");
        Reservation reservation = new Reservation(date, name);
        vacation.setReservation(reservation);
    }

    @Override
    public void addSpecialEvent(String date, String name) {
        System.out.println("VacationBuilder.addSpecialEvent");
        SpecialEvent specialEvent = new SpecialEvent(date, name);
        vacation.setSpecialEvent(specialEvent);
    }

    @Override
    public void addTickets(String movieName) {
        System.out.println("VacationBuilder.addTickets");
        Ticket ticket = new Ticket(movieName);
        vacation.setTicket(ticket);
    }

    @Override
    public Planner getVacationPlanner() {
        System.out.println("VacationBuilder.getVacationPlanner");
        return new Planner(vacation);
    }
}
