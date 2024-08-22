package example.bridge;

// Bridge 패턴에서의 Implementor에 해당 - 구현의 클래스 계층
public abstract class DisplayImpl {

    // ConcreteImplementor에서 구현할 메서드 정의
    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}
