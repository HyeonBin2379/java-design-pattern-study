package example.abstractfactory.factory;

// Abstract Factory 패턴의 AbstractProduct에 해당
// List, Tray가 공통으로 사용하는 메서드를 정의
public abstract class Item {

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    // List, Tray의 ConcreteProduct에서 구현할 메서드 정의
    // html 파일에 기록할 내용을 작성
    public abstract String makeHTML();
}
