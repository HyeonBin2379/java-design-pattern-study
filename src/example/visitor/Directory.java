package example.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Visitor 패턴에서의 ConcreteElement이자 ObjectStructure에 해당
public class Directory extends Entry implements Iterable<Entry> {

    private final String name;
    private final List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // Entry에 정의된 공통 메서드 구현
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        SizeVisitor visitor = new SizeVisitor();
        accept(visitor);
        return visitor.getSize();
    }

    // 현재 디렉토리에 지정한 파일 추가
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    /* ObjectStructure에 저장된 각각의 Element를
        ConcreteVisitor가 하나씩 취급하기 위한 메서드 */
    @Override
    public Iterator<Entry> iterator() {
        return directory.iterator();
    }

    /* Element에 정의된 accept() 메서드 구현 */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
