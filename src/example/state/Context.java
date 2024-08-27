package example.state;

// State 패턴에서의 Context에 해당
public interface Context {

    /* State 패턴을 실제로 이용하기 위한 메서드들을 정의 */
    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);

    // 주간/야간 설정 조건 변경용 템플릿 메서드
    default boolean isDay(int hour) {
        return hour >= 7 && hour < 18;
    }
}
