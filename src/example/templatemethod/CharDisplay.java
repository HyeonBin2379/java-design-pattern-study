package example.templatemethod;

// Template Method 패턴의 ConcreteClass에 해당
public class CharDisplay extends AbstractDisplay{

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    // AbstractDisplay에서 정의된 메서드를 구현
    @Override
    public void open() {
        // 시작 문자열 "<<"를 표시
        System.out.print("<<");
    }

    @Override
    public void close() {
        // 종료 문자열 ">>"를 표시
        System.out.println(">>");
    }

    @Override
    public void print() {
        // 문자를 출력
        System.out.print(ch);
    }
}
