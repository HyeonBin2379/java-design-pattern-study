package example.chainofresponsibility;

// Chain of Responsibility 패턴에서의 Handler에 해당
public abstract class Support {

    private final String name;
    private Support next;

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 현재 Handler의 다음에 연결할 Handler를 지정
    // 처리할 수 없는 요청을 전가할 때도 활용
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // Handler의 요청 처리 및 책임 전가 메서드(재귀적으로 처리)
    // Client의 요청이 발생하면 이 메서드를 호출하도록 public으로 설정
    public void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    // 요청 처리 성공 또는 실패 시 지정한 문구 출력
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }

    /* Handler에서 요청 처리가 가능한 조건을 정의 */
    protected abstract boolean resolve(Trouble trouble);    // 오직 Support와 그 하위 클래스만 호출 가능

    @Override
    public String toString() {
        return String.format("[%s]", name);
    }
}
