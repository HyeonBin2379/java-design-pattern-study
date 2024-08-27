package example.state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

// State 패턴에서의 Context에 해당
// Context에 정의된 추상 메서드를 구현(ConcreteContext)
public class SafeFrame extends Frame implements Context {

    private final TextField textClock = new TextField(60);
    private final TextArea textScreen = new TextArea(10, 60);

    /* 상태 전환을 위해 현재 상태 저장 */
    private State state = DayState.getInstance();

    private int hour;   // 로그 작성을 위해 현재 시간 저장

    public SafeFrame(String title) {
        super(title);

        // 배경색 및 레이아웃 설정
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        // 부품 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        // 부품 배치 - 버튼
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

        // 리스너 설정 - 누른 버튼에 따른 처리 수행
        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));

        // 실행창 표시
        pack();
        setVisible(true);
    }

    /* 아래는 모두 State 패턴의 Context 인터페이스에 정의된 추상 메서드를 구현한 메서드
    * (SafeFrame은 일종의 ConcreteContext) */

    // 시간 설정
    @Override
    public void setClock(int hour) {
        String clockString = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
        this.hour = hour;
    }

    // 상태 전환
    @Override
    public void changeState(State state) {
        System.out.printf("%s에서 %s로 상태가 변화했습니다.\n", this.state, state);
        this.state = state;
    }

    // 비상벨 호출 로그 작성
    @Override
    public void callSecurityCenter(String msg) {
        String callLog = String.format("[%02d:00] Call! %s\n", this.hour, msg);
        textScreen.append(callLog);
    }

    // 통화 로그 작성
    @Override
    public void recordLog(String msg) {
        String recordLog = String.format("[%02d:00] Record... %s\n", this.hour, msg);
        textScreen.append(recordLog);
    }
}
