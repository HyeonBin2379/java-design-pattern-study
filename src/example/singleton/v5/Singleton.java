package example.singleton.v5;

public class Singleton {

    private static class LazyHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return LazyHolder.instance;
    }

    // 여기부터는 추가 기능에 관한 메서드를 작성
}
