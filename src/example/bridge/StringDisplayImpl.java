package example.bridge;

// Bridge 패턴의 ConcreteImplementor에 해당 - 구현의 클래스 계층
public class StringDisplayImpl extends DisplayImpl{

    private final String string;
    private final int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    // Implementor에 정의된 각각의 메서드를 구현
    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.println("+" + "-".repeat(width) + "+");
    }
}
