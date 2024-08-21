package example.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Builder 패턴의 Builder를 담당하는 클래스(추상클래스 사용)
public abstract class Builder {

    // 생성할 파일을 저장할 디렉토리 경로(상수로 처리)
    private static final String DIRECTORY_PATH = "src\\example\\builder\\";

    // Builder와 상속관계인 클래스에서만 접근, 즉 ConcreteBuiler만 사용 가능
    protected final StringBuilder sb = new StringBuilder();

    // 인스턴스의 각 부분을 만드는 메서드 정의, ConcreteBuilder에서 구현할 메서드
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

    // 파일 생성용 템플릿 메서드(코드 중복 방지용)
    final void makefile(String filename, String content) {
        try {
            // 파일 저장 경로는 지정한 디렉토리 경로 + 파일이름(확장자 포함)
            Writer writer = new FileWriter(DIRECTORY_PATH + filename);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
