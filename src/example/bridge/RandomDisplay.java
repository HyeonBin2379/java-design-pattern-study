package example.bridge;

import java.util.Random;

public class RandomDisplay extends CountDisplay {

    private final Random random = new Random();

    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    // 지정한 숫자 범위 내 임의의 횟수만큼 출력
    public void randomDisplay(int times) {
        multiDisplay(random.nextInt(times));
    }
}
