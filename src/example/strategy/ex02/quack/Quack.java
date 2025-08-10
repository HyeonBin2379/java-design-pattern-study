package example.strategy.ex02.quack;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack.quack");
    }
}
