package exercise.adapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ExtendedFileProperties extends Properties implements FileIO{

    public ExtendedFileProperties() {
        super();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileReader(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileWriter(filename), "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
