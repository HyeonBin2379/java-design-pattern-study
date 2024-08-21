package example.prototype;

import example.prototype.framework.Manager;
import example.prototype.framework.Product;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();    // Client

        // 원형이 되는 인스턴스를 생성
        UnderlinePen uPen = new UnderlinePen('-');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');

        // Client는 원형이 되는 인스턴스를 저장
        manager.register("strong message", uPen);
        manager.register("warning box", mBox);
        manager.register("slash box", sBox);

        // 원형을 복제한 새로운 인스턴스를 사용
        Product p1 = manager.create("strong message");  // 원형의 복제본 생성
        p1.use("Hello, world!");
        System.out.println();

        Product p2 = manager.create("warning box");
        p2.use("Hello, world!");
        System.out.println();

        Product p3 = manager.create("slash box");
        p3.use("Hello, world!");
    }
}
