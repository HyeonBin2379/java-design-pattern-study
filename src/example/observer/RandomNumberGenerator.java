package example.observer;

import java.util.Random;

// Observer 패턴에서의 ConcreteSubject에 해당
public class RandomNumberGenerator extends NumberGenerator {

    private final Random random = new Random();
    private int number;     // Subject의 현재 상태를 나타내는 정수값

    /* 아래의 두 메서드는 Subject에 정의된 메서드를 구현 */
    // ConcreteSubject의 현재 상태를 반환
    @Override
    public int getNumber() {
        return number;
    }

    // ConcreteSubject의 현재 상태를 갱신한 후 이를 등록된 모든 Observer에게 통지
    @Override
    public void execute() {
        // 임의의 정수값을 15회 부여
        for (int i = 0; i < 15; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}