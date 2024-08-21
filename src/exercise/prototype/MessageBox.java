package exercise.prototype;

import exercise.prototype.framework.Product;

public class MessageBox extends Product {

    private final char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    public void use(String s) {
        int decoLen = 1 + s.length() + 1;
        System.out.println(String.valueOf(decoChar).repeat(decoLen));
        System.out.println(decoChar + s + decoChar);
        System.out.println(String.valueOf(decoChar).repeat(decoLen));
    }
}
