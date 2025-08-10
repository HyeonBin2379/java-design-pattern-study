package example.strategy.ex02.duck;

public class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("DecoyDuck.display");
        performFly();
        performQuack();
        System.out.println();
    }
}
