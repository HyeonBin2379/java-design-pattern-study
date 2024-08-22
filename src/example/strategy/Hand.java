package example.strategy;

public enum Hand {
    // 가위 바위 보를 나타내는 3개의 enum 상수
    ROCK("바위", 0),
    SCISSOR("가위", 1),
    PAPER("보", 2);

    private final String name;      // 가위 바위 보 손의 이름
    private final int handValue;    // 가위 바위 보 손의 값

    private static final Hand[] hands = Hand.values();

    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    // 손의 값으로 enum 상수 사용
    public static Hand getHand(int handValue) {
        return hands[handValue];
    }
    // 가위바위보에서 승리
    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }
    // 가위바위보에서 패배
    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    // 가위바위보 규칙
    private int fight(Hand hand) {
        if (this.handValue == hand.handValue) { // 무승부
            return 0;
        } else if ((this.handValue + 1) % 3 == hand.handValue) {    // 승리
            return 1;
        } else {    // 패배
            return -1;
        }
    }

    // 가위 바위 보의 문자열 표현
    @Override
    public String toString() {
        return name;
    }
}
