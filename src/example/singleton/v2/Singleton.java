package example.singleton.v2;

public class Singleton {

    private static final Singleton uniqueSingleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return uniqueSingleton;
    }

    // 여기부터는 추가 기능에 관한 메서드를 작성
}
