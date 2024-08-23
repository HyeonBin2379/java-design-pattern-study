package example.composite;

import java.util.ArrayList;
import java.util.List;

// Composite 패턴에서의 Composite에 해당
public class Directory extends Entry {

    private final String name;

    // Composite는 같은 Composite나 Leaf를 모두 저장 가능
    private final List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // 디렉터리에 다른 디렉터리나 파일을 추가할 때 사용
    /* Composite가 Component로부터 자식을 얻어 특정한 작업을 수행 */
    public Entry add(Entry entry) {
        directory.add(entry);
        entry.setParent(this);
        return this;
    }

    // 아래는 Entry에서 정의된 메서드듣을 Directory에서 구현
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
