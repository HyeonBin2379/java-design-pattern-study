package example.decorator;

// 실행 테스트용 샘플 코드
public class Main {

    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, World!!");   // 장식 없이 문자열 출력
        Display b2 = new SideBorder(b1, '#');     // 문자열의 좌우를 장식
        Display b3 = new FullBorder(b2);                    // b2에 전체 장식틀을 부착
        b1.show();
        System.out.println();

        b2.show();
        System.out.println();

        b3.show();
        System.out.println();

        // 지정한 문자열에 여러 개의 장식틀을 중첩
        Display b4 =
                new FullBorder(
                        new UpDownBorder(
                                new SideBorder(
                                        new UpDownBorder(
                                                new SideBorder(
                                                        new StringDisplay("Hello, World."),
                                                        '*'
                                                ),
                                                '='
                                        ),
                                        '|'
                                ),
                                '/'
                        )
                );
        b4.show();
        System.out.println();

        // 여러 줄의 문자열을 출력
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Hi!");
        md.add("Good morning.");
        md.add("Good night!");
        md.show();
        System.out.println();

        // 여러 줄의 문자열을 장식
        Display d5 = new SideBorder(md, '#');
        d5.show();
        System.out.println();

        // 여러 줄의 문자열 전체에 장식틀 부착
        Display d6 = new FullBorder(md);
        d6.show();
    }
}
