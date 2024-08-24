package example.chainofresponsibility;

// Chain of Responsibility 패턴의 ConcreteHandler에 해당
public class LimitSupport extends Support {

    private final int limit;    // 한계치

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    /* Handler에서의 요청 처리가 가능한 조건을 구체화 */
    // 한계치를 초과하지 않으면 처리 가능
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() <= limit;
    }
}
