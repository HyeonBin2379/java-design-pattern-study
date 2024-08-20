package example.factorymethod;

import example.factorymethod.framework.Factory;
import example.factorymethod.framework.Product;
import example.factorymethod.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        // ConcreteCreator 인스턴스를 통해 Product의 하위 클래스의 인스턴스를 생성
        System.out.println("Registering cards:");
        Product card1 = factory.create("Sam");
        Product card2 = factory.create("Joe");
        Product card3 = factory.create("John");
        System.out.println();

        // 생성된 각각의 Product 인스턴스는 서로 다른 인스턴스
        System.out.println("Using cards:");
        card1.use();
        card2.use();
        card3.use();
    }
}
