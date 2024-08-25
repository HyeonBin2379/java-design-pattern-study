package example.mediator;

// Mediator 패턴의 Mediator에 해당
public interface Mediator {

    // Colleague를 생성
    void createColleagues();

    // Colleague의 상태가 바뀌었을 시 호출
    void colleagueChanged();
}
