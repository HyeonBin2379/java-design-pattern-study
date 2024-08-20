package example.factorymethod.framework;

// Factory Method 패턴의 Creator에 해당
// 추상클래스로 구현
public abstract class Factory {

    // Creator의 템플릿 메서드로,Creator의 하위 클래스에 관계없이 동일하게 구현
    public final Product create(String owner) {
        // ConcreteProduct의 인스턴스 생성이 ConcreteProduct에 해당되는 클래스 이름에 구애받지 않도록
        // 인스턴스 생성 메서드를 상위 클래스인 Product로 업캐스팅
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 하위 클래스에서 구현해야 하는 메서드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
