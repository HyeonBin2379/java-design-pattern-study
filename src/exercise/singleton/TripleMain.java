package exercise.singleton;

public class TripleMain {

    public static void main(String[] args) {
        System.out.println("Start.");

        // 각각 "ALPHA", "BETA", "GAMMA"라는 이름이 붙은 인스턴스 생성
        // TripleClass를 사용한 경우
//        TripleClass a1 = TripleClass.getInstance("ALPHA");
//        TripleClass b1 = TripleClass.getInstance("BETA");
//        TripleClass c1 = TripleClass.getInstance("GAMMA");
//
//        TripleClass a2 = TripleClass.getInstance("ALPHA");
//        TripleClass b2 = TripleClass.getInstance("BETA");
//        TripleClass c2 = TripleClass.getInstance("GAMMA");

        // TripleEnum을 사용한 경우
        TripleEnum a1 = TripleEnum.getInstance("ALPHA");
        TripleEnum b1 = TripleEnum.getInstance("BETA");
        TripleEnum c1 = TripleEnum.getInstance("GAMMA");

        TripleEnum a2 = TripleEnum.getInstance("ALPHA");
        TripleEnum b2 = TripleEnum.getInstance("BETA");
        TripleEnum c2 = TripleEnum.getInstance("GAMMA");

        // 생성한 인스턴스가 유일한지 확인
        // TripleClass, TripleEnum 모두 Singleton 클래스
        if (a1 == a2) {
            System.out.println("a1 == a2 (" + a1 + ")");
        } else {
            System.out.println("a1 != a2");
        }

        if (b1 == b2) {
            System.out.println("b1 == b2 (" + b1 + ")");
        } else {
            System.out.println("b1 != b2");
        }

        if (c1 == c2) {
            System.out.println("c1 == c2 (" + c1 + ")");
        } else {
            System.out.println("c1 != c2");
        }
        System.out.println("End.");
    }
}
