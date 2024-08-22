package example.strategy;

import java.util.Arrays;
import java.util.Random;

// Strategy 패턴에서 ConcreteStrategy에 해당
// 과거의 승무패 이력을 활용하여 각각의 손을 낼 확률을 계산하는 전략
public class ProbStrategy implements Strategy{

    private final Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;

    // 대전 상대의 가위바위보 방법에 일종의 패턴이 있다고 전제
    // 직전, 이번에 낼 손에 따른 가위바위보 패턴별 승리 횟수 - 값이 클수록 승리 확률 높음
    private final int[][] history = {{1,1,1}, {1,1,1}, {1,1,1}};

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    private int getSum(int handValue) {
        return Arrays.stream(history[handValue]).reduce(0, Integer::sum);
    }

    // 아래의 두 메서드는 Strategy에서 정의한 메서드를 구체적으로 구현한 메서드
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue;
        if (bet < history[currentHandValue][0]) {
            handValue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if(win) {
            // 승리한 경우 이번과 같은 방식으로 이길 확률 증가
            history[prevHandValue][currentHandValue]++;
        } else {
            // 승리하지 못한 경우 이번과 다른 방식으로 이길 확률 증가
            history[prevHandValue][(currentHandValue+1) % 3]++;
            history[prevHandValue][(currentHandValue+2) % 3]++;
        }
    }
}
