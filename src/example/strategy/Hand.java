package example.strategy;

public enum Hand {
    ROCK("바위", 0),
    SCISSOR("가위", 1),
    PAPER("보", 2);

    private final String name;
    private final int handValue;

    private static final Hand[] hands = Hand.values();

    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }
    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }
    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this.handValue == hand.handValue) {
            return 0;
        } else if ((this.handValue + 1) % 3 == hand.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
