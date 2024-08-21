package exercise.builder;

public class JavaSourceBuilder implements Builder {

    private static final String PACKAGE_NAME = "exercise.builder";

    private final StringBuilder sb = new StringBuilder();
    private String filename = "Sample";

    @Override
    public void makeTitle(String title) {
        filename = title + ".java";
        sb.append(String.format("package %s;\n\n", PACKAGE_NAME));
        sb.append(String.format("public class %s {\n\n", title));
        sb.append("    public static void main(String[] args) {\n\n");
        sb.append("\t\tSystem.out.println(\"==================\");\n");
    }

    @Override
    public void makeString(String str) {
        sb.append(String.format("\t\tSystem.out.println(\"■ %s\");\n", str));
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append(String.format("\t\tSystem.out.println(\"   · %s\");\n", item));
        }
        sb.append("\t\tSystem.out.println();\n");
    }

    @Override
    public void close() {
        sb.append("\t\tSystem.out.println(\"==================\");\n");
        sb.append("    }\n");
        sb.append("}");
    }

    public String getJavaClassResult() {
        makefile(filename, sb.toString());
        return filename;
    }
}
