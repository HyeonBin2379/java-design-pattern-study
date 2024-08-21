package example.builder;

// Builder 패턴의 Director에 해당
public class Director {

    private final Builder builder;

    // Builder로 업캐스팅된 ConcreteBuilder를 주입
    // Director가 ConcreteBuilder를 직접적으로 사용하지 않는 것이 가능한 이유
    public Director(Builder builder) {
        this.builder = builder;
    }

    // Director는 Builder에서 정의한 메서드를 호출하여 생성할 파일의 각 부분을 작성
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("일반적인 인사");
        builder.makeItems(new String[]{"How are you?", "Hello.", "Hi."});
        builder.makeString("시간대별 인사");
        builder.makeItems(new String[]{"Good morning.", "Good afternoon", "Good evening"});
        builder.close();
    }
}
