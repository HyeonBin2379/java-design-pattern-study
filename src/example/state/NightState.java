package example.state;

// State 패턴에서의 ConcreteState에 해당
// 야간의 상태를 표현
public class NightState implements State {

    /* ConcreteState에는 Singleton 패턴을 적용 */
    private static final NightState singleton = new NightState();

    private NightState() {
    }

    public static NightState getInstance() {
        return singleton;
    }

    @Override
    public String toString() {
        return "[야간]";
    }

    /* 아래는 모두 State 인터페이스에 정의된 메서드를 구현한 것으로, 현재 상태에 따른 처리를 수행
     * (Context를 주입함으로써 Context에게 처리를 위임) */

    @Override
    public void doClock(Context context, int hour) {    // 현재 시간에 따라 주간으로 전환
        if (context.isDay(hour)) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {    // 야간 금고 사용 기록 작성
        context.callSecurityCenter("비상: 야간 금고 사용!");
    }

    @Override
    public void doAlarm(Context context) {  // 야간 비상벨 작동 기록 작성
        context.callSecurityCenter("비상벨(야간)");
    }

    @Override
    public void doPhone(Context context) {  // 야간 통화 기록 작성
        context.recordLog("야간 통화 녹음");
    }
}