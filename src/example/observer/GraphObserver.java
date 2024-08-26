package example.observer;

// Observer 패턴에서의 ConcreteObserver에 해당
public class GraphObserver implements Observer{

    // ConcreteObserver에서는 Observer에 정의된 메서드를 구현
    @Override
    public void update(NumberGenerator generator) {
        // Subject로부터 통지받은 정수값을 히스토그램으로 출력
        System.out.printf("GraphObserver: %s", "*".repeat(generator.getNumber()));
        System.out.println();
        // 관측 시 처리 양상이 잘 드러나도록 각 관측마다 약간의 시간차 부여
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}