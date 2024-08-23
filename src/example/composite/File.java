package example.composite;

// Composite 패턴에서의 Leaf에 해당
// Component에 해당하는 Entry를 상속받아 그 추상메서드를 구현
public class File extends Entry {

    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /* Leaf에서는 Entry에서 정의된 추상메서드를 구현*/
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    /* Composite 패턴의 재귀적 구조를 활용하여 파일의 절대경로를 구하여 출력*/
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
