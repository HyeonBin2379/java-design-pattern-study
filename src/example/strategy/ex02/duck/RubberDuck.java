package example.strategy.ex02.duck;

import example.strategy.ex02.fly.FlyNoWay;
import example.strategy.ex02.fly.MuteQuack;

public class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("RubberDuck.display");
        performFly();
        performQuack();
        System.out.println();
    }
}
