package example.visitor;

// Visitor 패턴의 Visitor에 해당
public interface Visitor {

    // visit 메서드는 ConcreteElement 방문 시 처리 방식을 정의한 메서드
    void visit(File file);              // File 방문 시 처리방식을 정의
    void visit(Directory directory);    // Directory 방문 시 처리방식 정의
}
