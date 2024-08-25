package example.facade;

import example.facade.pagemaker.PageMaker;

// Facade 패턴에서의 Client에 해당
// 실행용 샘플 코드
public class Main {

    public static void main(String[] args) {
        // 지정한 이메일 주소로 welcome.html이라는 이름의 웹 페이지 작성
        PageMaker.makeWelcomePage("maildata", "tester@example.com", "welcome.html");

        // 지정한 데이터파일에 포함된 사용자 이메일 주소 링크 페이지 생성
        PageMaker.makeLinkPage("maildata", "linkpage.html");
    }
}