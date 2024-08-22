package example.strategy;

// Strategy 패턴의 Context에 해당
public class Player {

    private final String name;

    // 위임 방식을 통해 전략을 적용하여 필요에 따라 전환 가능
    private final Strategy strategy;

    private int winCount;
    private int loseCount;
    private int gameCount;

    // 의존성 주입을 통해 Strategy 적용
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정
    public Hand nextHand() {
        return strategy.nextHand();
    }

    // 승리, 패배, 무승부에 따라 가위바위보 횟수 추가
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return String.format("[%s: %d games, %d win, %d lose]", name, gameCount, winCount, loseCount);
    }
}
