package example.visitor;

// Visitor 패턴에서 ConcreteVisitor에 해당
public class SizeVisitor implements Visitor {

    private int size = 0;

    public int getSize() {
        return size;
    }

    /* Visitor 패턴에 정의된 visit 메서드를 구현 */
    @Override
    public void visit(File file) {  // File의 크기 계산 방식
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {    //  Directory의 크기 계산 방식
        for (Entry entry : directory) {
            entry.accept(this);
        }
    }
}
