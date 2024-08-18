package exercise.factorymethod;

import exercise.factorymethod.framework.Factory;
import exercise.factorymethod.framework.Product;
import exercise.factorymethod.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        System.out.println("Registering cards:");
        Product card1 = factory.createProduct("Jane");
        Product card2 = factory.createProduct("Ann");
        Product card3 = factory.createProduct("John");
        System.out.println();

        System.out.println("Using cards:");
        card1.use();
        card2.use();
        card3.use();
    }
}
