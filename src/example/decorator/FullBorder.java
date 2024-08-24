package example.decorator;

// Decorator 패턴의 ConcreteDecorator에 해당
public class FullBorder extends Border {

    // ConcreteDecorator에서 위임할 Component 추가
    public FullBorder(Display display) {
        super(display);
    }

    // 구체적인 장식 방법을 나타내기 위해 Component에게 위임하는 방식으로 Decorator의 추상 메서드를 구현
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows()+1) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row-1) + "|";
        }
    }

    private String makeLine(char ch, int count) {
        return String.valueOf(ch).repeat(Math.max(0, count));
    }
}
