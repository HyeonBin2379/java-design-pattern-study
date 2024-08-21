package exercise.prototype;

import exercise.prototype.framework.Manager;
import exercise.prototype.framework.Product;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen uPen = new UnderlinePen('=');
        UnderlinePen uPen2 = new UnderlinePen('-');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');

        manager.register("strong underline", uPen);
        manager.register("underline", uPen2);
        manager.register("warning box", mBox);
        manager.register("slash box", sBox);

        Product p1 = manager.create("strong underline");
        p1.use("Hello, world!");
        System.out.println();

        Product p2 = manager.create("underline");
        p2.use("Hello, world!");
        System.out.println();

        Product p3 = manager.create("warning box");
        p3.use("Hello, world!");
        System.out.println();

        Product p4 = manager.create("slash box");
        p4.use("Hello, world!");
    }
}
