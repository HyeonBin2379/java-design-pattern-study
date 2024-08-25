package example.facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

// Facade 패턴에서 Facade의 제어를 받는 클래스에 해당
// Facade가 포함된 패키지 내부에서만 접근 가능하도록 클래스, 생성자에서 public 생략
class HtmlWriter {

    // 주입한 Writer에게 처리를 위임
    private final Writer writer;

    // 생성한 인스턴스는 Facade만 사용 가능
    // Facade가 포함된 패키지 내부에서만 사용가능하도록 public 생략
    HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    // html 형식으로 타이틀 작성
    public void title(String title) throws IOException {
        String html = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>%s</title>
                    </head>
                    <body>
                        <h1>%s</h1>
                """.formatted(title, title);
        writer.write(html);
    }

    // html 형식으로 단락 작성
    public void paragraph(String msg) throws IOException {
        String html = """
                        <p>%s</p>
                """.formatted(msg);
        writer.write(html);
    }

    // html 형식으로 링크 작성
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    // html 형식으로 이메일 주소 작성
    public void mailTo(String mailAddr, String username) throws IOException {
        link("mailto:" + mailAddr, username);
    }

    // html 닫기
    public void close() throws IOException {
        writer.write("    </body>\n");
        writer.write("</html>\n");
        writer.close();
    }
}
