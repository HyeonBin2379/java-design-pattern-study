package exercise.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public interface Builder {

    String RESOURCES = "src\\exercise\\builder\\";

    void makeTitle(String title);
    void makeString(String str);
    void makeItems(String[] items);
    void close();

    // 코드 중복을 방지하기 위해 default 메서드로 구현
    default void makefile(String filename, String contents) {
        try {
            Writer writer = new FileWriter(RESOURCES + filename);
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
