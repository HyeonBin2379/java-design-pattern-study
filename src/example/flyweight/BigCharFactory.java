package example.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight 패턴에서의 FlyweightFactory에 해당
public class BigCharFactory {

    /* 이미 생성된 BigChar 인스턴스 관리
       (여기에 저장된 BigChar 인스턴스를 공유) */
    private final Map<String, BigChar> pool = new HashMap<>();

    /* FlyweightFactory에 Singleton 패턴 적용 */
    private static final BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    /* Flyweight 패턴의 핵심 메서드 - 이미 생성된 인스턴스면 공유, 없으면 새로 생성 */
    /* synchronized 사용: 멀티스레드 환경에서 해당 메서드 호출 시 인스턴스 생성 여부를 잘못 판단하는 것을 방지하기 위해 사용 */
    public synchronized BigChar getBigChar(char charName) {
        BigChar bc = pool.get(String.valueOf(charName));
        if (bc == null) {
            bc = new BigChar(charName);
            pool.put(String.valueOf(charName), bc);
        }
        return bc;
    }
}
