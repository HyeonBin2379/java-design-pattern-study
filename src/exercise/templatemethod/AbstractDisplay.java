package exercise.templatemethod;

public interface AbstractDisplay {

    // 하위 클래스에 따라 구현 양상이 달라지는 메서드
    void open();
    void close();
    void print();

    // 탬플릿 메서드 - 모든 하위 클래스에서 항상 동일하게 동작하는 메서드
    // final 키워드를 사용 불가능하여 하위 메서드가 탬플릿 메서드를 오버라이딩할 수 있음
    default void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
