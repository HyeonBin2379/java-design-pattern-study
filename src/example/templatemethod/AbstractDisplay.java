package example.templatemethod;

public abstract class AbstractDisplay {

    // 상속관계/같은 패키지에 있는 클래스에서만 호출할 경우 public 대신 protected 사용
    public abstract void open();
    public abstract void close();
    public abstract void print();

    // 이 메서드는 AbstractDisplay의 하위 클래스에서 오버라이딩 불가능
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
