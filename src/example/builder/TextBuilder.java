package example.builder;

public class TextBuilder extends Builder {

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
        makefile(filename, sb.toString());
    }

    public String getTextResult() {
        return sb.toString();
    }
}
