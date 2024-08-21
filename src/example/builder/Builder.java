package example.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class Builder {

    private static final String RESOURCES = "src\\example\\builder\\";
    protected final StringBuilder sb = new StringBuilder();

    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

    final void makefile(String filename, String content) {
        try {
            Writer writer = new FileWriter(RESOURCES + filename);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
