package example.templatemethod;

public class CharDisplay extends AbstractDisplay{

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

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
        System.out.print(ch);
    }
}
