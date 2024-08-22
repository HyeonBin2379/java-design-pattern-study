package example.strategy;

public class Main {

    public static void main(String[] args) {
        // 명령행 인자는 2개만 사용하며, 이는 난수를 생성하는 시드
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);

        /* Strategy 패턴 사용: player1, player2는 서로 다른 가위바위보 전략을 선택
        * */
        Player player1 = new Player("KIM", new WinningStrategy(seed1));
        Player player2 = new Player("LEE", new ProbStrategy(seed2));

        // 10000회 대전 후 결과 출력
        for (int i = 0; i < 10000; i++) {
            // 가위바위보 실시
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            // 가위바위보 결과 확인
            if (nextHand1.isStrongerThan(nextHand2)) {  // player1 승리
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {   // player2 승리
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");  // 무승부
                player1.even();
                player2.even();
            }
        }

        // 최종 결과 확인
        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
