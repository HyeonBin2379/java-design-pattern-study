package example.prototype.framework;

// Product 인터페이스의 기본 골격을 만들기 위한 추상 클래스
// clone 메서드, 복사 생성자 모두 활용하면서 코드 중복을 줄이기 위해 추가
public abstract class AbstractProduct implements Product {

    // ConcretePrototype에서 수행할 동작
    public abstract void use(String s);

    // clone 메서드를 사용한 인스턴스 복제에서 코드 중복을 줄이기 위해
    // 인스턴스 복제 메서드를 템플릿 메서드로 구현
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }
}
