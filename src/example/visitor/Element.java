package example.visitor;

// Visitor 패턴의 Element에 해당
public interface Element {

    // Visitor가 ConcreteElement를 방문하는 것을 허용하는 메서드
    void accept(Visitor visitor);
}
