package example.builder;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        Director director;
        switch (args[0]) {
            case "text":
                TextBuilder textBuilder = new TextBuilder();
                director = new Director(textBuilder);
                director.construct();
                System.out.println(textBuilder.getTextResult());
                break;
            case "html":
                HtmlBuilder htmlBuilder = new HtmlBuilder();
                director = new Director(htmlBuilder);
                director.construct();
                String filename = htmlBuilder.getHTMLResult();
                System.out.println(filename);
                System.out.println("HTML 파일 " + filename + "이 작성되었습니다.");
                break;
            default:
                usage();
                System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main text   텍스트로 문서 작성");
        System.out.println("Usage: java Main html   HTML 파일로 문서 작성");
    }
}
