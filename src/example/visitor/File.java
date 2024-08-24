package example.visitor;

// Visitor 패턴의 ConcreteElement에 해당
public class File extends Entry{

    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // Entry에 정의된 공통 메서드를 구현
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    // Element에 정의된 accept() 메서드 구현
    // 이 메서드 호출 시 Visitor의 visit() 메서드 실행
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
