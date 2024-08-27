package exercise.state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class SafeFrame extends Frame implements Context {

    private final TextField textClock = new TextField(60);
    private final TextArea textScreen = new TextArea(10, 60);

    private State state = DayState.getInstance();
    private int hour;

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        Button buttonUse = new Button("금고 사용");
        panel.add(buttonUse);

        Button buttonAlarm = new Button("비상벨");
        panel.add(buttonAlarm);

        Button buttonPhone = new Button("일반 통화");
        panel.add(buttonPhone);

        Button buttonExit = new Button("종료");
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));

        pack();
        setVisible(true);
    }

    @Override
    public void setClock(int hour) {
        String clockString = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
        this.hour = hour;
    }

    @Override
    public void changeState(State state) {
        System.out.printf("[%02d:00] %s에서 %s로 상태가 변화했습니다.\n", this.hour, this.state, state);
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        String callLog = String.format("[%02d:00] Call! %s\n", this.hour, msg);
        textScreen.append(callLog);
    }

    @Override
    public void recordLog(String msg) {
        String recordLog = String.format("[%02d:00] Record... %s\n", this.hour, msg);
        textScreen.append(recordLog);
    }
}
