package example.factorymethod.idcard;

import example.factorymethod.framework.Product;

// Factory Method 패턴에서의 ConcreteProduct에 해당
public class IDCard extends Product {

    private final String owner;

    // ConcreteProduct와 동일한 패키지에 속한 클래스에서만 ConcreteProduct의 생성자에 접근 가능
    // Factory Method 패턴의 Creator는 ConcreteProduct의 생성자를 직접 호출할 수 없음
    IDCard(String owner) {
        System.out.printf("%s의 카드를 만듭니다.\n", owner);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    // Product에서 정의된 추상 메서드를 구현
    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }
}
