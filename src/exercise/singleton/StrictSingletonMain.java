package exercise.singleton;

// 멀티스레드 환경에서 실행
public class StrictSingletonMain extends Thread {

    // 메인 스레드
    public static void main(String[] args) {
        System.out.println("Start.");

        // 멀티스레드 환경에서 Singleton 클래스의 getInstance 메서드 호출
        new StrictSingletonMain("A").start();
        new StrictSingletonMain("B").start();
        new StrictSingletonMain("C").start();

        System.out.println("End.");
    }

    // 각 서브스레드마다 실행할 코드: Singleton의 인스턴스 생성
    @Override
    public void run() {
        StrictSingleton obj = StrictSingleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    // 서브 스레드 생성
    public StrictSingletonMain(String name) {
        super(name);
    }
}
