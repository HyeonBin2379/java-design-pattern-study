package example.flyweight;

// Flyweight 패턴에서의 Flyweight에 해당
public interface FlyweightChar {

    /* 공유된 Flyweight 인스턴스가 사용할 기능을 정의 */
    void printChar();       // 문자 1개를 인쇄
}
