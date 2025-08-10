package example.strategy.ex02.duck;

import example.strategy.ex02.fly.FlyWithWings;
import example.strategy.ex02.quack.Quack;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("RedheadDuck.display");
        performFly();
        performQuack();
        System.out.println();
    }
}
