package example.state;

// 실행용 샘플 코드
public class Main {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            // 시간 단위로 주간/야간 금고 사용 로그 작성
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                // 다음 시간대 로그 출력 시 약간의 시간차 부여
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
