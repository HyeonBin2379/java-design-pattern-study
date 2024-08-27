package example.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar implements Flyweight {

    private char charName;
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            String filename = "big" + charName + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(DIRECTORY_PATH + filename))) {
                sb.append(line).append("\n");
            }
            this.fontData = sb.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    @Override
    public void print() {
        System.out.print(fontData);
    }
}
