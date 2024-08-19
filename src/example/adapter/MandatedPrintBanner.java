package example.adapter;

// Adapter 패턴의 Adapter에 해당
public class MandatedPrintBanner implements Print {

    // Adapter 내부에 Adaptee인 Banner의 인스턴스를 저장
    private final Banner banner;

    public MandatedPrintBanner(String string) {
        this.banner = new Banner(string);
    }

    // 아래의 두 메서드는 Adapter인 PrintBanner에서 재정의된 추상클래스 Print의 메서드
    // Adapter에 저장한 Adaptee의 인스턴스를 통해 간접적으로 메서드를 호출하여 Print의 메서드를 구현
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
