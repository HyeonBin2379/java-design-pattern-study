package exercise.singleton;

public class StrictSingletonMain extends Thread {

    public static void main(String[] args) {
        System.out.println("Start.");

        // getInstance에 동기화를 적용했을 때 singleton 인스턴스가 1회만 생성되는지 확인
        new StrictSingletonMain("A").start();
        new StrictSingletonMain("B").start();
        new StrictSingletonMain("C").start();

        System.out.println("End.");
    }

    @Override
    public void run() {
        StrictSingleton obj = StrictSingleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    public StrictSingletonMain(String name) {
        super(name);
    }
}
