package example.strategy;

import java.util.Random;

// Strategy 패턴의 ConcreteStrategy에 해당
// 마지막으로 이겼을 때 낸 대로 다음에 내는 방식
public class WinningStrategy implements Strategy {

    private final Random random;
    private boolean won = false;
    private Hand prevHand;      // 마지막으로 이겼을 때의 선택

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    // ConcreteStrategy는 Strategy에서 정의한 메서드를 구현
    @Override
    public Hand nextHand() {
        // 직전에 졌으면 다시 선택
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(Hand.values().length));
        }
        // 직전에 이겼으면 그 선택을 고수
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
