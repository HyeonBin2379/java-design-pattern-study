package exercise.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {

    private int money;
    private List<String> fruits = new ArrayList<>();
    private final Random random = new Random();
    private static final String[] fruitName = {"사과", "포도", "바나나", "오렌지"};

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
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

    private String getFruit() {
        String fruit = fruitName[random.nextInt(fruitName.length)];
        return random.nextBoolean() ? "맛있는 " + fruit : fruit;
    }

    public Memento createMemento() {
        Memento memento = new Memento(money);
        for (String fruit : fruits) {
            if (fruit.startsWith("맛있는 ")) {
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return String.format("[money = %d, fruits = %s]", money, fruits);
    }
}
