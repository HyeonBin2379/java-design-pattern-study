package example.strategy;

// Strategy 패턴의 Strategy에 해당
public interface Strategy {

    // 가위바위보에 대한 추상적인 전략을 정의, ConcreteStrategy에서 구현할 메서드
    Hand nextHand();            // 다음에 낼 손
    void study(boolean win);    // 직전의 가위바위보 결과를 반영
}
