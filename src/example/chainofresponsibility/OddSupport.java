package example.chainofresponsibility;

// Chain of Responsibility 패턴의 ConcreteHandler에 해당
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    /* 주어진 숫자가 홀수면 처리 가능 */
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
