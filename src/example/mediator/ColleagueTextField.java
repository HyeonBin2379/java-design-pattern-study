package example.mediator;

import java.awt.Color;
import java.awt.TextField;              // Java GUI의 텍스트창 관련 기능에 관한 클래스
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

// Mediator 패턴에서의 ConcreteColleague에 해당
public class ColleagueTextField extends TextField implements TextListener, Colleague {

    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    /* Colleague에 정의된 메서드를 구현 */
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.black);
    }

    // 텍스트 필드 내 입력에 변동사항이 발생하면 Mediator를 호출하여 후속처리를 요청
    // ConcreteColleague -> Mediator 방향의 요청 전달
    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
