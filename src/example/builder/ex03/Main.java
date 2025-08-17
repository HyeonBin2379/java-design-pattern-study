package example.builder.ex03;

public class Main {

    public static void main(String[] args) {
        Builder builder = new VacationBuilder();
        Client client = new Client(builder);
        client.constructPlanner();
    }
}
