package exercise.prototype;

import exercise.prototype.framework.Product;

public class UnderlinePen extends Product {

    private final char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    @Override
    public void use(String s) {
        int uLen = s.length();
        System.out.println(s);
        System.out.println(String.valueOf(ulChar).repeat(uLen));
    }
}
