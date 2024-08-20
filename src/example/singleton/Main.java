package example.singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        // 불러온 인스턴스가 서로 동일한 인스턴스인지 확인
        System.out.println(obj1);
        System.out.println(obj2);
        if (obj1 == obj2) {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        } else {
            System.out.println("obj1와 obj2는 같은 인스턴스가 아닙니다.");
        }
        System.out.println("End.");
    }
}
