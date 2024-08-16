package exercise.adapter;

import java.io.IOException;

public class Main {

    private static final String RESOURCE = "src\\exercise\\adapter\\";
    private static final String NEW_FILE = "newfile.txt";

    public static void main(String[] args) {
        FileIO f = new MandatedFileProperties();
        // FileIO f = new ExtendedFileProperties();

        try {
            f.readFromFile(RESOURCE + "file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile(RESOURCE + NEW_FILE);
            System.out.printf("%s is created\n", NEW_FILE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
