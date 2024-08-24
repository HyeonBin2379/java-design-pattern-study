package example.visitor;

// Element의 기본 골격을 제공하기 위해 사용
// File, Directory에서 공통으로 사용하는 메서드를 정의
public abstract class Entry implements Element {

    public abstract String getName();
    public abstract int getSize();

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
