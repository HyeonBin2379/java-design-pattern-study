// 이 패키지의 변경 사항은 AbstractFactory, AbstractProduct에게 영향을 끼치지 않음
package example.abstractfactory.listfactory;

import example.abstractfactory.factory.Link;

// Abstract Factory 패턴의 ConcreteProduct에 해당
public class ListLink extends Link {

    // Java에서는 생성자 상속이 불가능하므로 makeHTML 메서드 실행을 위해 상위 클래스의 생성자를 호출
    // ConcreteProduct는 AbstractProduct에 저장된 정보를 상속받아 사용
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    // AbstractProduct에 정의된 메서드를 구현
    // 필드에 저장된 링크 정보를 HTML 형식으로 작성
    @Override
    public String makeHTML() {
        return "                <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}