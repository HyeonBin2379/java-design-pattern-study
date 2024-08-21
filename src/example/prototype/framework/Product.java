package example.prototype.framework;

// Prototype 패턴의 Prototype에 해당
// clone 메서드를 사용하기 위해 Clonable을 상속받음(복사 생성자만 사용 시 생략 가능)
public interface Product extends Cloneable {

    // ConcretePrototype에서 수행할 동작 정의
    void use(String s);

    // 원형 인스턴스 복제 메서드: ConcretePrototype마다 그 방식은 상이할 수 있음
    Product createCopy();
}