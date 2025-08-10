package example.singleton.v1;

public class Singleton {

    private static Singleton uniqueSingleton;

    private Singleton() {}

//    public static Singleton getInstance() {
//        if (uniqueSingleton == null) {
//            uniqueSingleton = new Singleton();
//        }
//        return uniqueSingleton;
//    }

    public static synchronized Singleton getInstance() {
        if (uniqueSingleton == null) {
            uniqueSingleton = new Singleton();
        }
        return uniqueSingleton;
    }

    // 여기부터는 추가 기능에 관한 메서드를 작성
}
