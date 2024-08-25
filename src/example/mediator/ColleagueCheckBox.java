package example.mediator;

import java.awt.Checkbox;           // Java GUI의 라디오박스 관련 기능에 관한 클래스
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Mediator 패턴에서의 ConcreteColleague에 해당
public class ColleagueCheckBox extends Checkbox implements ItemListener, Colleague {

    private Mediator mediator;

    public ColleagueCheckBox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    /* Colleague에 정의된 메서드를 구현 */
    @Override
    public void setMediator(Mediator mediator) {    // 사용할 Mediator 지정
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {  // 지정한 조건 성립 시 텍스트 필드 활성화
        setEnabled(enabled);
    }

    // 선택한 라디오박스가 변경되었을 경우 Mediator를 호출하여 후속 처리를 요청
    // ConcreteColleague -> Mediator 방향의 요청 전달
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
