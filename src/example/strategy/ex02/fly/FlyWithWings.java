package example.strategy.ex02.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("FlyWithWings.fly");
    }
}
