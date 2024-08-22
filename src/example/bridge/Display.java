package example.bridge;

// Bridge 패턴의 Abstraction에 해당 - 기능의 클래스 계층
public class Display {

    /* Abstraction으로 대표되는 기능의 클래스 계층과
       Implementor로 대표되는 구현의 클래스 계층을 중개하는 필드
       (Bridge 패턴에서의 "다리") */
    private final DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    // Abstraction의 메서드는 Implementor에 정의된 메서드를 이용하여 구현
    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
