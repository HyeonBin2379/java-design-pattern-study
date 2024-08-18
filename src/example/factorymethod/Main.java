package example.factorymethod;

import example.factorymethod.framework.Factory;
import example.factorymethod.framework.Product;
import example.factorymethod.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        System.out.println("Registering cards:");
        Product card1 = factory.create("Sam");
        Product card2 = factory.create("Joe");
        Product card3 = factory.create("John");
        System.out.println();

        System.out.println("Using cards:");
        card1.use();
        card2.use();
        card3.use();
    }
}
