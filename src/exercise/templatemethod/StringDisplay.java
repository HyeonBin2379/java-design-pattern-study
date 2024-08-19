package exercise.templatemethod;

public class StringDisplay implements AbstractDisplay {

    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    private void printLine() {
        System.out.println("+" + "-".repeat(width) + "+");
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void close() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }
}
