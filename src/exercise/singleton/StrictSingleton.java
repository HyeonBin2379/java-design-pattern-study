package exercise.singleton;

public class StrictSingleton {

    private static StrictSingleton strictSingleton;

    private StrictSingleton() {
        System.out.println("인스턴스를 생성했습니다.");
        slowdown();
    }

    // 여러 개의 스레드에서 동시에 getInstance 메서드 호출 시 인스턴스가 여러 개 생성될 수 있음
    // 멀티스레드 환경에서도 singleton 패턴을 활용하려면 동기화 필요
    public static synchronized StrictSingleton getInstance() {
        // 최초로 생성하는 경우에만 인스턴스 생성
        if (strictSingleton == null) {
            strictSingleton = new StrictSingleton();
        }
        return strictSingleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
