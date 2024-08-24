package example.chainofresponsibility;

import java.util.Random;

// Chain of Responsibility 패턴의 Client에 해당
// 실행용 샘플 코드
public class Main {

    public static void main(String[] args) {
        // 6개의 ConcreteHandler 생성
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 생성한 ConcreteHandler를 연쇄적으로 연결
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 임의로 다양한 트러블 발생
        Random random = new Random();
        for (int i = 0; i < 500; i += random.nextInt(100)) {
            // 발생한 문제를 첫번째 ConcreteHandler부터 시작해서 순차적으로 전달
            alice.support(new Trouble(i));
        }
    }
}
