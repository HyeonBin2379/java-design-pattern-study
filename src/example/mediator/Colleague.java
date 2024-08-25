package example.mediator;

// Mediator 패턴에서의 Colleague에 해당
public interface Colleague {

    // 사용할 Mediator를 설정(메서드를 통한 의존성 주입)
    void setMediator(Mediator mediator);

    // 지정한 조건에 따라 Mediator에서의 활성/비활성을 지시
    void setColleagueEnabled(boolean enabled);
}
