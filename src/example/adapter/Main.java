package example.adapter;

// Adapter 패턴의 Client에 해당
public class Main {

    public static void main(String[] args) {
        // 업캐스팅을 통해 Adapter인 PrintBanner의 Target이 Print임을 표현

        //Print p = new ExtendedPrintBanner("Hello Java World");
        Print p = new MandatedPrintBanner("Hello World");

        // Client는 Target에서 정의된 메서드를 호출하여 사용
        p.printWeak();
        p.printStrong();
    }
}
