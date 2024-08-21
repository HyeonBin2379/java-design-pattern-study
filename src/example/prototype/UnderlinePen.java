package example.prototype;

import example.prototype.framework.AbstractProduct;

// Prototype 패턴의 ConcretePrototype에 해당
// clone 메서드를 사용하여 원형을 복제한 인스턴스 생성(템플릿 메서드 활용)
public class UnderlinePen extends AbstractProduct {

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
