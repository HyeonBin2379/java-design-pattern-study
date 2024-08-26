package exercise.memento;

import exercise.memento.game.Gamer;
import exercise.memento.game.Memento;

public class Main {

    public static final String SAVE_FILE_NAME = "src/exercise/memento/game.dat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);

        // 저장된 파일 불러오기
        Memento memento = Memento.loadFromFile(SAVE_FILE_NAME);
        if (memento == null) {
            System.out.println("새로 시작합니다.");
            memento = gamer.createMemento();
        } else {
            System.out.println("이전에 저장한 결과부터 시작합니다.");
            gamer.restoreMemento(memento);
        }

        // 게임 시작
        for (int i = 1; i <= 100; i++) {
            System.out.println("==== " + i);
            System.out.println("상태: " + gamer);

            gamer.bet();    // 게임 진행

            // Memento 취급 방침 결정
            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("※ 많이 늘었으니 현재 상태를 저장하자!");
                memento = gamer.createMemento();

                // 세이브파일로 저장
                if (Memento.saveToFile(SAVE_FILE_NAME, memento)) {
                    System.out.println("현재 상태를 파일로 저장했습니다.");
                }
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※ 많이 줄었으니 이전 상태를 복원하자!");
                gamer.restoreMemento(memento);
            }

            // 시간차를 두고 다음 턴 진행
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
