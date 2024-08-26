package exercise.observer;

public class IncrementalNumberGenerator extends NumberGenerator {

    private int number;
    private final int end;
    private final int increment;

    public IncrementalNumberGenerator(int start, int end, int increment) {
        this.number = start;
        this.end = end;
        this.increment = increment;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += increment;
        }
    }
}
