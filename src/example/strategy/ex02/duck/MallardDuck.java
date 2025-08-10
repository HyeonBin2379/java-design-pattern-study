package example.strategy.ex02.duck;

import example.strategy.ex02.fly.FlyWithWings;
import example.strategy.ex02.quack.Squeak;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck.display");
        performFly();
        performQuack();
        System.out.println();
    }
}
