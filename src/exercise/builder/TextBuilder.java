package exercise.builder;

public class TextBuilder implements Builder{

    private final StringBuilder sb = new StringBuilder();
    private String filename = "untitled.txt";

    @Override
    public void makeTitle(String title) {
        filename = title + ".txt";
        sb.append("===========================\n");
        sb.append(String.format("[%s]\n\n", title));
    }

    @Override
    public void makeString(String str) {
        sb.append(String.format("■ %s\n\n", str));
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append(String.format("  · %s\n", item));
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("===========================\n");
    }

    public String getTextResult() {
        makefile(filename, sb.toString());
        return sb.toString();
    }
}
