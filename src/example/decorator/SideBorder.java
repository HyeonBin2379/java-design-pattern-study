package example.decorator;

// Decorator 패턴의 ConcreteDecorator에 해당
public class SideBorder extends Border {

    private final char borderChar;

    // ConcreteDecorator에서 위임할 Component, 사용할 장식문자 추가
    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    // 구체적인 장식 방법을 나타내기 위해 Component에게 위임하는 방식으로 Decorator의 추상 메서드를 구현
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
