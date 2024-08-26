package exercise.observer;

public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.printf("GraphObserver: %s", "*".repeat(generator.getNumber()));
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
