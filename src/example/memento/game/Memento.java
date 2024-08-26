// Originator와 Memento는 동일한 패키지에 저장 - 외부의 Caretaker와 분리
package example.memento.game;

import java.util.ArrayList;
import java.util.List;

// Memento 패턴에서의 Memento에 해당
public class Memento {

    private final int money;
    private final List<String> fruits;

    // 이 메서드는 Caretaker에게 제공할 Originator의 정보를 반환
    // narrow interface에 해당 - public 사용
    public int getMoney() {
        return money;
    }

    /* 아래의 모든 메서드는 Caretaker가 접근 불가, Originator만 이전 정보 복원을 위해 접근 가능.
    *  Memento와 Originator에 해당되는 클래스만 접근 가능하므로 메서드는 default(접근제한자 X) */

    // Memento 생성자(wide interface)
    Memento(int money) {
        this.money = money;
        fruits = new ArrayList<>();
    }

    // 과일 추가(wide interface)
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // 현재 저장된 모든 과일들을 반환(wide interface)
    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }
}