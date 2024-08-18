package exercise.templatemethod;

public class StringDisplay implements AbstractDisplay {

    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
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

    private void printLine() {
        System.out.println("+" + "-".repeat(width) + "+");
    }
}
