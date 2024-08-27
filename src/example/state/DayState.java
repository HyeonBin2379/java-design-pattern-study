package example.state;

// State 패턴에서의 ConcreteState에 해당
// 주간의 상태를 표현
public class DayState implements State {

    /* ConcreteState에는 Singleton 패턴을 적용
    : 클래스 자체가 상태를 나타내기 때문에 이에 대한 여러 개의 인스턴스를 생성할 필요가 없기 때문 */
    private static final DayState singleton = new DayState();

    private DayState() {
    }

    public static DayState getInstance() {
        return singleton;
    }

    @Override
    public String toString() {
        return "[주간]";
    }

    /* 아래는 모두 State 인터페이스에 정의된 메서드를 구현한 것으로, 현재 상태에 따른 처리를 수행
    * (Context를 주입함으로써 Context에게 처리를 위임) */

    @Override
    public void doClock(Context context, int hour) { // 현재 시간에 따라 야간으로 전환
        if (!context.isDay(hour)) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {    // 주간 금고 사용 기록 작성
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {  // 주간 비상벨 작동 기록 작성
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {  // 주간 통화 기록 작성
        context.callSecurityCenter("일반 전화(주간)");
    }
}
