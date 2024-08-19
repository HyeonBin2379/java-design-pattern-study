package example.adapter;

// Adapter 패턴에서의 Adapter에 해당
// Adaptee인 Banner를 상속받아 Target인 Print에 정의된 메서드를 구현할 때 Banner의 메서드를 활용
public class ExtendedPrintBanner extends Banner implements Print {

    public ExtendedPrintBanner(String string) {
        super(string);
    }

    // 아래의 두 메서드는 Adaptee의 메서드를 활용하여 구현된 Target의 메서드
    // Adaptee의 메서드를 Target 메서드 블록 내부에서 호출하여 사용
    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}