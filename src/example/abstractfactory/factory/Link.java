package example.abstractfactory.factory;

// Abstract Factory 패턴의 AbstractProduct에 해당
// 이 클래스의 하위 클래스가 구현해야 할 메서드는 이미 Item에서 정의
// HTML 하이퍼링크를 추상적으로 표현
public abstract class Link extends Item {

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
