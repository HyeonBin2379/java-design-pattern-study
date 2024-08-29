package example.interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final String DIRECTORY_PATH = "src/example/interpreter/";

    public static void main(String[] args) {
        try {
            for (String text : Files.readAllLines(Path.of(DIRECTORY_PATH + "program.txt"))) {
                System.out.printf("text = \"%s\"\n", text);
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
