package example.adapter.mandated;

public class Main {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello World");
        p.printWeak();
        p.printStrong();
    }
}
