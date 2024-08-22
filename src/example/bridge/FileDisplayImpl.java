package example.bridge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDisplayImpl extends DisplayImpl {

    private static final String DIRECTORY_PATH = "src/example/bridge/";
    private final String filename;

    public FileDisplayImpl(String fileName) {
        this.filename = fileName;
    }

    @Override
    public void rawOpen() {
        System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-=");
    }

    @Override
    public void rawPrint() {
        try {
            for (String line : Files.readAllLines(Path.of(DIRECTORY_PATH + filename))) {
                System.out.print("> ");
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-=");
    }
}
