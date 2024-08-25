package example.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Facade 패턴의 Facade에 해당
public class PageMaker {

    // 생성한 html 파일을 저장할 디렉토리 경로
    private static final String DIRECTORY_PATH = "src/example/facade/pagemaker/";

    private PageMaker() {
    }

    /* Facade인 PageMaker가 Database, HtmlWriter 클래스를 제어하여 html 파일 생성 */
    // 웹 페이지 생성
    public static void makeWelcomePage(String dbName, String mailAddr, String filename) {
        try {
            // 데이터파일 내 지정한 이메일 주소로부터 사용자 이름 추출
            String username = Database.getProperties(dbName).getProperty(mailAddr);

            // 웹 페이지 작성
            HtmlWriter writer = new HtmlWriter(new FileWriter(DIRECTORY_PATH + filename));
            writer.title(username + "s web page!");
            writer.paragraph("Welcome to " + username + "s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailTo(mailAddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailAddr + " (" + username + ")");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // 링크 페이지 생성
    public static void makeLinkPage(String dbname, String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(DIRECTORY_PATH + filename));
            writer.title("Link Page");

            // 데이터파일에 저장된 각 이메일 주소별 링크 생성
            Properties mailProps = Database.getProperties(dbname);
            for (String mailAddr : mailProps.stringPropertyNames()) {
                String username = mailProps.getProperty(mailAddr, "(unknown)");
                writer.mailTo(mailAddr, username);
            }
            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}