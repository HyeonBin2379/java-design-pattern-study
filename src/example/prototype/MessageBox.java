package example.prototype;

import example.prototype.framework.AbstractProduct;
import example.prototype.framework.Product;

// Prototype 패턴의 ConcretePrototype에 해당
public class MessageBox extends AbstractProduct {

    private final char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }
    // 복사 생성자: 원형 인스턴스 복제의 수단
    private MessageBox(MessageBox prototype) {
        this.decoChar = prototype.decoChar;
    }

    // Prototype에서 정의한 메서드 구현
    @Override
    public void use(String s) {
        int decoLen = 1 + s.length() + 1;
        System.out.println(String.valueOf(decoChar).repeat(decoLen));
        System.out.println(decoChar + s + decoChar);
        System.out.println(String.valueOf(decoChar).repeat(decoLen));
    }

    /* AbstractProduct의 clone 메서드를 사용한 인스턴스 복제 메서드를
       복사 생성자를 사용하는 인스턴스 복제 메서드로 재정의 */
    @Override
    public Product createCopy() {
        return new MessageBox(this);
    }
}
