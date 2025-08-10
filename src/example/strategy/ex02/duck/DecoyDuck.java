package example.strategy.ex02.duck;

import example.strategy.ex02.fly.FlyNoWay;
import example.strategy.ex02.quack.Squeak;

public class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("DecoyDuck.display");
        performFly();
        performQuack();
        System.out.println();
    }
}
