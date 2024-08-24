package example.decorator;

// Decorator 패턴에서의 Component에 해당
public abstract class Display {

    // 내용물에 관한 추상 메서드를 정의
    // ConcreteComponent에서 구현하며, Decorator도 공통으로 정의되어 있는 추상 메서드
    public abstract int getColumns();
    public abstract int getRows();
    public abstract String getRowText(int row);

    // 내용물의 메서드지만 Decorator에서 장식할 메서드는 아님
    public void show() {
        for (int i = 0; i < this.getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
