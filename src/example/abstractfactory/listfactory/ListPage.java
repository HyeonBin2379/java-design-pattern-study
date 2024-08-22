package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Item;
import example.abstractfactory.factory.Page;

// Abstract Factory 패턴의 ConcreteProduct에 해당
public class ListPage extends Page {

    // AbstractProduct에 저장된 필드 정보를 상속받아 사용
    public ListPage(String title, String author) {
        super(title, author);
    }

    // Page에 정의된 메서드를 구현
    // 필드에 저장된 내용으로 HTML 페이지를 구성
    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html>\n");
        sb.append("    <head>\n");
        sb.append("        <meta charset=\"UTF-8\">\n");
        sb.append("        <title>").append(title).append("</title>\n");
        sb.append("    </head>\n");
        sb.append("    <body>\n");
        sb.append("        <h1>").append(title).append("</h1>\n");
        sb.append("        <ul>\n");

        // 추상 클래스 Item 클래스에 정의된 메서드를 호출하므로
        // 다른 ConcreteProduct와는 독립적으로 동작 가능
        for (Item item : content) {
            sb.append(item.makeHTML());
        }
        sb.append("        </ul>\n");
        sb.append("        <hr><address>");
        sb.append(author);
        sb.append("</address>\n");
        sb.append("    </body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }
}
