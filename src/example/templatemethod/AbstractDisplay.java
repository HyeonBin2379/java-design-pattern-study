package example.templatemethod;

// Template Method 패턴의 AbstractClass에 해당
// 추상 클래스로 구현
public abstract class AbstractDisplay {

    // 상속관계/같은 패키지에 있는 클래스에서만 호출하려면 public 대신 protected 사용
    // 하위 클래스에 따라 구현 양상이 달라지는 메서드
    public abstract void open();
    public abstract void close();
    public abstract void print();

    // 탬플릿 메서드
    // final을 사용하여 메서드의 재할당을 막음으로써 하위 클래스에서의 오버라이딩 불가
    // 모든 하위 클래스에서 항상 동일하게 사용하는 메서드
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}