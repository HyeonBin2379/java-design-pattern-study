package exercise.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public interface Builder {

    String RESOURCES = "src\\exercise\\builder\\";
    StringBuilder sb = new StringBuilder();

    void makeTitle(String title);
    void makeString(String str);
    void makeItems(String[] items);
    void close();

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
