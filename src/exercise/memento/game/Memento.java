package exercise.memento.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Memento {

    private final int money;
    private final List<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    /* Memento에 저장된 Original의 상태를 파일로 저장 */
    public static boolean saveToFile(String fileName, Memento memento) {
        StringBuilder sb = new StringBuilder();
        // 소지금
        sb.append(String.format("%d\n", memento.money));

        // 과일
        for (String fruit : memento.fruits) {
            sb.append(String.format("%s\n", fruit));
        }

        // 파일에 쓰기
        try {
            Files.writeString(Path.of(fileName), sb,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /* 파일에 저장된 Originator의 상태를 Memento로 변환 */
    public static Memento loadFromFile(String fileName) {
        try {
            // 파일 읽기
            List<String> lines = Files.readAllLines(Path.of(fileName));
            if (lines.isEmpty()) {
                System.out.println("Empty file");
                return null;
            }

            // 소지금
            int money;
            try {
                money = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                System.out.printf("Format error: %s\n", e.getMessage());
                return null;
            }

            // 소지금 정보로 Memento 생성 후 과일 저장 정보 복원
            Memento memento = new Memento(money);
            for (int i = 1; i < lines.size(); i++) {
                memento.addFruit(lines.get(i));
            }
            return memento;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
