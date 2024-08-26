package example.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Memento 패턴에서의 Originator에 해당
public class Gamer {

    private int money;      // 소지금
    private List<String> fruits = new ArrayList<>();    // 현재 저장된 과일 목록
    private final Random random = new Random();         // 주사위 던지기를 위한 난수 생성기
    private static final String[] fruitName = {"사과", "포도", "바나나", "오렌지"};   // 선택 가능한 과일

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() { // 주사위를 던져서 게임 진행
        int dice = random.nextInt(6)+1;
        switch (dice) {
            case 1:
                money += 100;
                break;
            case 2:
                money /= 2;
                break;
            case 6:
                String fruit = getFruit();
                fruits.add(fruit);
                System.out.printf("과일 (%s)를 받았습니다.\n", fruit);
                break;
            default:
                System.out.println("변동 사항이 없습니다.");
        }
    }

    private String getFruit() { // 임의로 과일 선택 후 반환
        String fruit = fruitName[random.nextInt(fruitName.length)];
        // 과일 앞에 임의로 수식어 추가 후 반환
        return random.nextBoolean() ? "맛있는 " + fruit : fruit;
    }


    /* Originator의 현재 상태를 Memento에 저장 */
    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String fruit : fruits) {
            // 과일은 맛있는 것만 저장
            if (fruit.startsWith("맛있는 ")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    /* Memento에 저장된 이전 상태로 Originator를 복원 */
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return String.format("[money = %d, fruits = %s]", money, fruits);
    }
}
