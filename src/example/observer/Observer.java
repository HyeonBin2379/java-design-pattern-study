package example.observer;

// Observer 패턴에서의 Observer에 해당
public interface Observer {

    // Subject의 내용 갱신 시 Observer에게 그 갱신 내역을 통지
    void update(NumberGenerator generator);
}
