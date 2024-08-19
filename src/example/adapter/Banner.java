package example.adapter;

// Adapter 패턴의 Adaptee에 해당
public class Banner {

    private final String string;

    public Banner(String string) {
        this.string = string;
    }

    // 아래 두 메서드는 Adapter에서 Target의 메서드를 구현할 때 활용
    public void showWithParen() {
        System.out.printf("(%s)\n", string);
    }

    public void showWithAster() {
        System.out.printf("*%s*\n", string);
    }
}
