package exercise.builder;

public class HtmlBuilder implements Builder {

    private final StringBuilder sb = new StringBuilder();
    private String filename = "untitled.html";

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        sb.append("<!DOCTYPE html>");
        sb.append("<html>\n");
        sb.append("<head>\n<meta charset=\"UTF-8\">\n<title>");
        sb.append(title);
        sb.append("</title>\n</head>\n");
        sb.append("<body>\n");
        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>");
        sb.append(str);
        sb.append("</p>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for (String item : items) {
            sb.append("<li>");
            sb.append(item);
            sb.append("</li>\n");
        }
        sb.append("</ul>\n\n");
    }

    @Override
    public void close() {
        sb.append("</body>\n");
        sb.append("</html>\n");
    }

    public String getHTMLResult() {
        makefile(filename, sb.toString());
        return filename;
    }
}
