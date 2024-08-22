package example.abstractfactory;

import example.abstractfactory.factory.Factory;
import example.abstractfactory.factory.Link;
import example.abstractfactory.factory.Page;
import example.abstractfactory.factory.Tray;

// Abstract Factory 패턴의 Client에 해당: AbstractFactory를 가동
public class Main {

    // AbstractFactory에 의해 생성된 파일을 저장할 폴더 경로
    private static final String DIRECTORY_PATH = "src/example/abstractfactory/result/";

    public static void main(String[] args) {
        // 명령행 인자는 2개만 입력
        if (args.length != 2) {
            System.out.println("Usage: java Main filename.html class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main list.html listfactory.ListFactory");
            System.out.println("Example 2: java Main list divfactory.DivFactory");
            System.exit(0);
        }

        String filename = args[0];
        String classname = args[1];

        // 사용하고자 하는 ConcreteFactory로부터 인스턴스를 생성
        Factory factory = Factory.getFactory(classname);

        /* 아래의 모든 작업들은 ConcreteFactory, ConcreteProduct를 직접적으로 사용하지 않고도
        *  추상 클래스 AbstractFactory, AbstractProduct에 정의된 메서드로만 구현된 내부 코드에 의해 동작
        *  (Abstract Factory 패턴)
        * */
        // Blog
        Link blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Link blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Link blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        // News
        Link news1 = factory.createLink("News 1", "https://example.com/news1");
        Link news2 = factory.createLink("News 2", "https://example.com/news2");
        Tray news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"));
        news3.add(factory.createLink("News 3 (Korea)", "https://example.com/news3kr"));

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        // Page
        Page page = factory.createPage("Blog and News", "Tester");
        page.add(blogTray);
        page.add(newsTray);
        page.output(DIRECTORY_PATH + filename);

    }
}
