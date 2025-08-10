package example.strategy.ex02.fly;

import example.strategy.ex02.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("MuteQuack.quack");
    }
}
