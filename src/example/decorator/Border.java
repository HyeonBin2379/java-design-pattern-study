package example.decorator;

// Decorator 패턴의 Decorator에 해당
// Decorator인 Border는 Component인 Display와 동일한 추상 메서드를 정의(해당 메서드는 상속)
public abstract class Border extends Display {

    // Decorator인 Border가 감쌀 내용물
    // 위임 방식 사용: Decorator와 Component를 동일시
    protected Display display;

    // 장식할 내용물을 지정(의존성 주입)
    protected Border(Display display) {
        this.display = display;
    }
}
