package example.builder.ex03;

public class Planner {

    private Vacation vacation;

    public Planner(Vacation vacation) {
        this.vacation = vacation;
    }

    public Vacation getVacation() {
        return vacation;
    }

    @Override
    public String toString() {
        return vacation.toString();
    }
}
