package example.observer;

// Observer 패턴에서의 ConcreteSubject에 해당
public class IncrementalNumberGenerator extends NumberGenerator {

    private int number;         // Subject의 현재 상태를 나타내는 정수값
    private final int end;      // 가능한 number의 최대값
    private final int increment;

    public IncrementalNumberGenerator(int start, int end, int increment) {
        this.number = start;
        this.end = end;
        this.increment = increment;
    }

    /* 아래의 두 메서드는 Subject에 정의된 메서드를 구현 */
    // ConcreteSubject의 현재 상태를 반환
    @Override
    public int getNumber() {
        return number;
    }

    // 등록된 모든 Observer에게 ConcreteSubject의 현재 상태를 통지 후 그 상태를 갱신
    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();      // 현재 상태 통지
            number += increment;    // 상태 갱신
        }
    }
}
