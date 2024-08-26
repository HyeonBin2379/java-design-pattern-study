package example.observer;

import java.util.ArrayList;
import java.util.List;

// Observer 패턴에서의 Subject에 해당
public abstract class NumberGenerator {

    // 하나의 Subject는 Observer 여러 개 등록 가능
    private final List<Observer> observers = new ArrayList<>();

    // Observer 추가/삭제 메서드
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Subject의 상태 변화를 등록한 모든 Observer에게 통지
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    // ConcreteSubject에서 구현할 메서드
    public abstract int getNumber();    // Subject의 현재 상태를 반환
    public abstract void execute();     // Subject의 상태 갱신 후 Observer에게 통지
}