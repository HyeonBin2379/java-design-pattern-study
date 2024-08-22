package example.bridge;

public class Main {

    public static void main(String[] args) {
        // 업캐스팅을 통해 Display, CountDisplay가 모두 동일한 클래스 계층에 속한다는 것을 표현
        // 아래의 두 인스턴스는 Display가 제공하는 기본 기능만 사용
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World!"));

        // CountDisplay에 새로 추가된 기능을 사용하는 경우
        // CountDisplay에만 있는 메서드를 호출하기 위해 필드의 타입은 생성한 인스턴스와 동일
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe!"));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, World!"));

        CountDisplay d5 = new CountDisplay(new FileDisplayImpl("star.txt"));
        IncreaseDisplay d6 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        IncreaseDisplay d7 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);

        // 아래 두 메서드는 기본 기능만 사용
        d1.display();
        System.out.println();

        d2.display();
        System.out.println();

        // 기본 기능과 CountDisplay에 추가된 새로운 기능을 사용
        d3.display();
        System.out.println();

        d3.multiDisplay(5);
        System.out.println();

        d4.display();
        System.out.println();

        d4.randomDisplay(10);
        System.out.println();

        d5.multiDisplay(3);
        System.out.println();

        d6.increaseDisplay(4);
        System.out.println();

        d7.increaseDisplay(6);
    }
}
