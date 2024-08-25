package example.mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Mediator 패턴에서의 ConcreteMediator에 해당
public class LoginFrame extends Frame implements ActionListener, Mediator {

    // ConcreteMediator를 통해 서로 상호작용할 ConcreteColleague들
    private ColleagueCheckBox checkGuest;
    private ColleagueCheckBox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOK;
    private ColleagueButton buttonCancel;

    // ConcreteMediator인 로그인 대화상자에 Colleague를 생성하고 배치한 후 표시
    public LoginFrame(String title) {
        super(title);   // ConcreteMediator의 타이틀 설정

        setBackground(Color.lightGray);     // 배경색 설정

        setLayout(new GridLayout(4, 2));    // 대화상자의 크기 설정

        /* ConcreteMediator를 통해 중재할 Colleague를 생성한 후 배치 */
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOK);
        add(buttonCancel);

        /* 활성/비활성에 관한 초기 설정 */
        colleagueChanged();


        pack();     // 생성한 로그인 대화상자 표시
        setVisible(true);
    }

    /* 아래 2개는 Mediator에 정의된 메서드를 구현 */
    // Colleague를 생성
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup group = new CheckboxGroup();
        checkGuest = new ColleagueCheckBox("Guest", group, true);
        checkLogin = new ColleagueCheckBox("Login", group, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button
        buttonOK = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator 설정
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOK.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정: Colleague에서의 변화를 감지하여 Mediator에게 전달할 때 사용
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    /* Colleague의 상태가 바뀔 시 그 후속처리를 수행 */
    // Mediator -> Colleague 방향의 상호작용: 모든 Colleague의 상태가 변화
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {    // 게스트 로그인
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(true);
        } else {    // 사용자 로그인
            textUser.setColleagueEnabled(true);
            userPassChanged();
        }
    }

    // textUser나 textPass의 변경 여부에 따라 각 Colleague의 활성/비활성을 판정
    private void userPassChanged() {
        if (!textUser.getText().isEmpty()) {
            textPass.setColleagueEnabled(true);

            // 사용자 이름과 패스워드는 모두 4글자 이상만 가능
            buttonOK.setColleagueEnabled(textUser.getText().length() >= 4
                    && textPass.getText().length() >= 4);
        } else {
            textPass.setColleagueEnabled(false);
            buttonOK.setColleagueEnabled(false);
        }
    }

    // OK/Cancel 버튼 클릭 시 콘솔창에 로그 출력
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
