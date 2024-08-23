package example.composite;

// Composite 패턴에서의 Component에 해당
public abstract class Entry {

    private Entry parent;

    // prefix를 앞에 붙인 파일 리스트를 출력
    protected abstract void printList(String prefix);
    // 부모 설정
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // Leaf, Composite가 사용할 메서드를 정의
    public abstract String getName();
    public abstract int getSize();
    public void printList() {
        printList("");
    }

    // 파일의 전체 경로를 반환
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        Entry entry = this;
        do {
            fullName.insert(0, entry.getName());
            fullName.insert(0, "/");
            entry = entry.parent;
        } while (entry != null);
        return fullName.toString();
    }

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
