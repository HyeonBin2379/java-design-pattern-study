package example.strategy.ex02.duck;

import example.strategy.ex02.fly.FlyBehavior;
import example.strategy.ex02.quack.QuackBehavior;

public abstract class Duck {

    // 오리 객체의 행동은 런타임 중 객체를 생성할 때 결정됨
    // 인터페이스 타입의 객체를 내부에 둠으로써, 수행할 행동이 교체되어도 정상 실행
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("Duck.swim");
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }


    // setter 주입을 활용하여 수행할 행동 변경
    // : 사용할 FlyBehavior, QuackBehavior 구현체가 변경되어도 Duck 객체의 코드 변경 불필요
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
