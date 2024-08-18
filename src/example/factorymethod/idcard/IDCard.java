package example.factorymethod.idcard;

import example.factorymethod.framework.Product;

public class IDCard extends Product {

    private String owner;

    // IDCard의 인스턴스는 반드시 IDCardFactory를 경유해야 생성 가능
    IDCard(String owner) {
        System.out.printf("%s의 카드를 만듭니다.\n", owner);
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
