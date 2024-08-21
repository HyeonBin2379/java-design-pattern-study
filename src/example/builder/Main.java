package example.builder;

// Builder 패턴의 Client에 해당
public class Main {

    public static void main(String[] args) {
        // 명령행 인자를 1개만 입력
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        // 첫번째 명령행 인자의 값에 따라 Director에 주입할 ConcreteBuilder를 결정
        Director director;
        switch (args[0]) {
            case "text":
                // ConcreteBuilder에만 포함된 최종 결과 반환 메서드를 사용해야 하므로 업캐스팅 X
                // 텍스트 파일 생성
                TextBuilder textBuilder = new TextBuilder();
                director = new Director(textBuilder);
                director.construct();

                System.out.println(textBuilder.getTextResult());    // 최종 결과 반환
                break;
            case "html":
                // HTML 파일 생성
                HtmlBuilder htmlBuilder = new HtmlBuilder();
                director = new Director(htmlBuilder);
                director.construct();

                String filename = htmlBuilder.getHTMLResult();      // 최종 결과 반환
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
