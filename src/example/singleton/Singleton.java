package example.singleton;

public class Singleton {

    // 프로그램 실행을 시작할 때 말고는 이 클래스의 생성자를 따로 호출하지 않음
    // 더 이상 이 필드에 인스턴스를 재할당하지 않는다는 것을 명시하기 위해 final 키워드를 추가함
    private static final Singleton singleton = new Singleton();

    // 생성자는 이 클래스 내부에서만 호출 가능(private)
    private Singleton() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    // 생성된 유일한 인스턴스를 반환
    public static Singleton getInstance() {
        return singleton;
    }
}
