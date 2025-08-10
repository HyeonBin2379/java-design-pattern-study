package example.strategy.ex02.fly;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("FlyNoWay.fly");
    }
}
