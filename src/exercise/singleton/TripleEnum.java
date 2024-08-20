package exercise.singleton;

public enum TripleEnum {

    // enum 상수
    ALPHA, BETA, GAMMA;

    // enum 상수에 대응되는 인스턴스를 public static final로 생성
    TripleEnum() {
        System.out.println("The instance " + this + " is created");
    }

    // 지정한 enum 상수의 이름을 반환
    public static TripleEnum getInstance(String name) {
        return TripleEnum.valueOf(name);
    }
}
