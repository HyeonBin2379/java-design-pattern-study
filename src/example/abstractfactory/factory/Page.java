package example.abstractfactory.factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

// Abstract Factory 패턴의 AbstractProduct에 해당
// HTML 페이지 전체를 추상적으로 표현
public abstract class Page {

    protected String title;     // 페이지 제목
    protected String author;    // 페이지 작성자
    protected List<Item> content = new ArrayList<>();   // 페이지에 저장될 내용

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    /* 핵심 로직에 관한 메서드는 AbstractProduct 내부에서 모두 구현되므로,
     * ConcreteFactory, ConcreteProduct에서의 변경 내역의 영향을 받지 않음 */

    public void output(String filename) {
        try {
            // html 형식으로 작성된 내용을 지정한 html 파일에 추가
            Files.writeString(Path.of(filename), makeHTML(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
            System.out.println(filename + " 파일을 작성했습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // html 파일에 기록할, 페이지 관련 내용을 작성, ConcreteProduct에서 구현
    public abstract String makeHTML();
}
