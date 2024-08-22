package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Item;
import example.abstractfactory.factory.Tray;

// Abstract Factory 패턴의 ConcreteProduct에 해당
public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    // Tray의 상위 클래스인 Item에 정의된 메서드를 구현
    // HTML 형식으로 출력할 내용에 관한 리스트 블록 추가
    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("        <li>\n");
        sb.append("            ").append(caption);
        sb.append("\n            <ul>\n");

        // 추상 클래스 Item 클래스에 정의된 메서드를 호출하므로
        // 다른 ConcreteProduct와는 독립적으로 동작
        for (Item item : tray) {
            sb.append(item.makeHTML());
        }
        sb.append("            </ul>\n");
        sb.append("        </li>\n");
        return sb.toString();
    }
}
