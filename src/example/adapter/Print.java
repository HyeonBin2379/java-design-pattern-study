package example.adapter;

// Adapter 패턴의 Target에 해당
public interface Print {

    // Client가 사용하려는 메서드를 정의
    void printWeak();
    void printStrong();
}
