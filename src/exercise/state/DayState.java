package exercise.state;

public class DayState implements State {

    private static final DayState singleton = new DayState();

    private DayState() {
    }

    public static DayState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(NightState.getInstance());
        } else if (hour == 12) {
            context.changeState(NoonState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 전화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
