package example.flyweight;

public class Main {

    private static BigString[] bsArray = new BigString[10000];

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs;
        System.out.println("공유한 경우:");
        bs = new BigString(args[0], false);
        bs.print();
        showMemory();
        System.out.println();

        System.out.println("공유하지 않은 경우:");
        bs = new BigString(args[0], true);
        bs.print();
        showMemory();
        System.out.println();

        System.out.println("10000회 실행 - 공유한 경우:");
        testAllocation(true);
        System.out.println("10000회 실행 - 공유하지 않은 경우:");
        testAllocation(false);
    }

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
