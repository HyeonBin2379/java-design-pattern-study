package exercise.templatemethod;

public class Main {

    public static void main(String[] args) {
        // 인터페이스에서도 업캐스팅 가능
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello java world!!");

        // 메서드 실행
        d1.display();
        d2.display();
    }
}
