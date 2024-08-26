package example.observer;

// 실행용 샘플 코드
public class Main {

    public static void main(String[] args) {
        // 사용할 Subject 생성
        //NumberGenerator generator = new RandomNumberGenerator();    // 임의 숫자로 갱신
        NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);    // 10~50 범위에서 5씩 증가

        // 사용할 Observer 생성 후 Subject에 등록
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        // 실행
        generator.execute();
    }
}
