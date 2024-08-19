package example.templatemethod;

public class Main {

    public static void main(String[] args) {
        // 업캐스팅: AbstractClass에 그 하위 클래스인 CharDisplay, StringDisplay의 인스턴스를 대입
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello world.");

        // 하위 클래스를 통해 완전히 구현된 템플릿 메서드 실행
        // 템플릿 메서드 내부에서는 업캐스팅에 쓰인 각각의 하위 클래스마다 구현된 메서드를 호출
        d1.display();
        d2.display();
    }
}
