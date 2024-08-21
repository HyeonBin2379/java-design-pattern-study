package example.builder;

// Builder 패턴의 ConcreteBuilder에 해당
public class HtmlBuilder extends Builder {

    // 파일 이름의 초기값
    private String filename = "untitled.html";

    // Builder에서 정의한 메서드를 구현
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


    // ConcreteBuilder는 Builder에서 정의한 메서드 이외에도 최종 결과물을 반환하는 메서드를 정의
    // HTML 파일 생성 후 파일 이름을 반환
    public String getHTMLResult() {
        makefile(filename, sb.toString());
        return filename;
    }
}
