package example.builder.ex03;

public class Hotel {

    private String date;
    private String name;

    public Hotel(String date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
