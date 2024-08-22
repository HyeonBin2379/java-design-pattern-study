package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Factory;
import example.abstractfactory.factory.Link;
import example.abstractfactory.factory.Page;
import example.abstractfactory.factory.Tray;

// Abstract Factory 패턴의 ConcreteFactory에 해당
// 프로그램 실행 중에 AbstractFactory가 사용
public class ListFactory extends Factory {

    // AbstractFactory에서 정의된 AbstractProduct 생성 메서드 구현
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
