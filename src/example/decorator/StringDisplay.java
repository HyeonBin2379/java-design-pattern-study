package example.decorator;

// Decorator 패턴의 ConcreteComponent에 해당
public class StringDisplay extends Display {

    private final String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    /* Decorator 패턴의 Component에 정의된 추상 메서드를 구현*/
    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
