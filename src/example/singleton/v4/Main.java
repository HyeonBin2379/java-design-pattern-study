package example.singleton.v4;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.UNIQUE_INSTANCE;
        Singleton obj2 = Singleton.UNIQUE_INSTANCE;

        // 불러온 인스턴스가 서로 동일한 인스턴스인지 확인
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        } else {
            System.out.println("obj1와 obj2는 같은 인스턴스가 아닙니다.");
        }
        System.out.println("End.");
    }
}
