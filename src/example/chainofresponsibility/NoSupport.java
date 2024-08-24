package example.chainofresponsibility;

// Chain of Responsibility 패턴의 ConcreteHandler에 해당
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    // Handler에서 요청 처리가 가능흔 조건을 구현
    // 요청 처리가 불가능
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
