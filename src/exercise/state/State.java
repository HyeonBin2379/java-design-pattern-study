package exercise.state;

// State 패턴에서의 State에 해당
public interface State {

    void doClock(Context context, int hour);    // 시간 설정
    void doUse(Context context);                // 금고 사용
    void doAlarm(Context context);              // 비상벨
    void doPhone(Context context);              // 일반 통화
}
