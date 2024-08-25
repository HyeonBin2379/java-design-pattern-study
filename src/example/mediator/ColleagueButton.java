package example.mediator;

import java.awt.Button;     // Java의 GUI의 버튼 관련 기능을 다루는 클래스

// Mediator 패턴에서의 ConcreteColleague에 해당 - Mediator의 메서드에서 사용될 클래스
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    /* Colleague에서 정의된 메서드를 구현 */
    // 사용할 Mediator를 설정
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // 버튼 활성화/비활성화 지시
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
