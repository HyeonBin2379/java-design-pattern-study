package exercise.singleton;

// 멀티스레드 환경까지 고려한, 조금 더 엄격한 Singleton 패턴
public class StrictSingleton {

    private static StrictSingleton strictSingleton;

    // 멀티스레드 환경에서 약간의 시간차를 두고 인스턴스 생성
    // 이 클래스의 생성자는 클래스 외부로 노출되지 않음
    private StrictSingleton() {
        System.out.println("인스턴스를 생성했습니다.");
        slowdown();
    }

    // 멀티스레드 환경에서 Singleton 패턴을 온전히 구현하려면 인스턴스 생성 메서드의 동기화 필수
    public static synchronized StrictSingleton getInstance() {
        // 이미 생성된 인스턴스가 있으면 새로운 인스턴스 생성 X
        if (strictSingleton == null) {
            strictSingleton = new StrictSingleton();
        }
        return strictSingleton;
    }

    // 멀티스레드 환경에서 호출된 인스턴스 생성 메서드를 비동기적으로 처리
    // : 한 스레드에서 static 필드에 인스턴스를 할당하는 작업이 완료되기 전에 다른 스레드가 static 필드에 접근
//    public static StrictSingleton getInstance() {
//        // 이미 생성된 인스턴스가 있으면 새로운 인스턴스 생성 X
//        if (strictSingleton == null) {
//            strictSingleton = new StrictSingleton();
//        }
//        return strictSingleton;
//    }

    // 각 스레드 실행 시 약간의 시간차를 부여
    private void slowdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
