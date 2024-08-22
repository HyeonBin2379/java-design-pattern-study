package example.strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {

    private final Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(Hand.values().length));
    }

    @Override
    public void study(boolean win) {
    }
}
