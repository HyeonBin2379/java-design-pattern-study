package example.adapter.extended;

public class Banner {

    private final String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.printf("(%s)", string);
    }

    public void showWithAster() {
        System.out.printf("(%s)", string);
    }
}
