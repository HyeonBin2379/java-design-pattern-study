package example.chainofresponsibility;

// Chain of Responsibility 패턴의 ConcreteHandler에 해당
public class SpecialSupport extends Support {

    private final int number;   // 타겟

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    // 특별한 숫자값을 가지면 Handler가 처리 가능
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
