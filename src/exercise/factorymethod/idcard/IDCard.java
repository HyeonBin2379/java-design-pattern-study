package exercise.factorymethod.idcard;

import exercise.factorymethod.framework.Product;

public class IDCard extends Product {

    private final String owner;
    private final int serial;

    IDCard(String owner, int serial) {
        System.out.printf("%s의 카드를 %d번으로 생성합니다.\n", owner, serial);
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return String.format("[IDCard:%s(%d)]", owner, serial);
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
