package example.memento;

import example.memento.game.Gamer;
import example.memento.game.Memento;

// Memento 패턴에서의 Caretaker에 해당
public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);

        /* Originator의 최초 상태를 Memento에 저장 */
        Memento memento = gamer.createMemento();

        for (int i = 1; i <= 100; i++) {
            // 현 시점에서의 Originator의 상태 출력
            System.out.println("==== " + i);
            System.out.println("상태: " + gamer);

            gamer.bet();    // 게임 진행

            /* 현재 Originator의 상태를 Memento에 새로 저장할 것인지,
               Memento에 저장된 이전 상태를 불러올 것인지를 결정  */
            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("※ 많이 늘었으니 현재 상태를 저장하자!");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("※ 많이 줄었으니 이전 상태를 복원하자!");
                gamer.restoreMemento(memento);
            }

            // 약간의 시간차를 둔 후 다음 턴 진행
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
