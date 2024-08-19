package example.templatemethod;

// Template Method 패턴의 ConcreteClass에 해당
public class StringDisplay extends AbstractDisplay {

    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    private void printLine() {
        System.out.println("+" + "-".repeat(width) + "+");
    }

    // AbstractDisplay에서 정의된 메서드를 구현
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
