package example.flyweight;

// 실행용 샘플 코드
public class Main {

    private static final BigString[] bsArray = new BigString[10000];

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        // Flyweight 패턴을 사용하는 경우 - 1회 실행
        BigString bs;
        System.out.println("1회 실행 - BigChar 인스턴스 공유:");
        bs = new BigString(args[0], true);
        bs.print();
        showMemory();
        System.out.println();

        // Flyweight 패턴을 사용하지 않는 경우 - 1회 실행
        System.out.println("1회 실행 - BigChar 인스턴스 미공유:");
        bs = new BigString(args[0], false);
        bs.print();
        showMemory();
        System.out.println();

        System.out.println("10000회 실행 - BigChar 인스턴스 공유:");
        testAllocation(true);
        System.out.println("10000회 실행 - BigChar 인스턴스 미공유:");
        testAllocation(false);
    }

    // 10000회 반복 실행 후 메모리 사용량 출력
    public static void testAllocation(boolean shared) {
        for (int i = 0; i < bsArray.length; i++) {
            bsArray[i] = new BigString("1234", shared);
        }
        showMemory();
    }
    public static void showMemory() {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("사용 메모리 = " + used);
    }
}
