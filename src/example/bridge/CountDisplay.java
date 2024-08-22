package example.bridge;

// Bridge 패턴에서의 RefinedAbstraction에 해당 - 기능의 클래스 계층
// Display와 CountDisplay는 큰 틀에서 동일한 기능이므로 상속을 통해 강하게 연결
public class CountDisplay extends Display {

    /* Java에서는 생성자 상속이 불가능하므로
       상위 클래스인 Display에서 주입받은 Implementor를 현재 클래스에서 사용하기 위해
       이 클래스의 생성자로 상위 생성자를 호출
     */
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    // 새로 추가된 기능
    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
