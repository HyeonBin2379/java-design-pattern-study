package example.strategy.ex02;

import example.strategy.ex02.duck.DecoyDuck;
import example.strategy.ex02.duck.Duck;
import example.strategy.ex02.duck.MallardDuck;
import example.strategy.ex02.duck.RedheadDuck;
import example.strategy.ex02.duck.RubberDuck;
import example.strategy.ex02.fly.FlyWithWings;
import example.strategy.ex02.quack.Quack;
import example.strategy.ex02.quack.Squeak;

public class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck redheadDuck = new RedheadDuck();
        Duck rubberDuck = new RubberDuck();

        // 여러 개의 오리 객체마다 서로 다른 행동 수행 가능
        mallardDuck.display();
        redheadDuck.display();
        rubberDuck.display();

        // decoyDuck의 행동을 설정
        Duck decoyDuck = new DecoyDuck();
        decoyDuck.setFlyBehavior(new FlyWithWings());
        decoyDuck.setQuackBehavior(new Squeak());
        decoyDuck.display();

        // setter를 통해 decoyDuck의 QuackBehavior를 변경
        decoyDuck.setQuackBehavior(new Quack());
        decoyDuck.display();
    }
}
