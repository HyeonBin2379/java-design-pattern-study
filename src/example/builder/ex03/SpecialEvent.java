package example.builder.ex03;

public class SpecialEvent {

    private String date;
    private String eventName;

    public SpecialEvent(String date, String eventName) {
        this.date = date;
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "SpecialEvent{" +
                "date='" + date + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
