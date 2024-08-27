package example.flyweight;

// Flyweight 패턴에서의 Client에 해당
public class BigString {

    private BigChar[] bigChars;     // '큰 문자열'

    // 생성자
    // 인스턴스 공유 가능 여부에 따라 Flyweight 패턴 적용 여부를 결정
    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    /* Flyweight 패턴을 적용하는 경우 */
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();  // FlyweightFactory 생성
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i)); // 이미 생성된 BigChar 인스턴스를 공유
        }
    }

    /* Flyweight 패턴을 적용하지 않는 경우 */
    private void initUnshared(String string) {
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < string.length(); i++) {
            bigChars[i] = new BigChar(string.charAt(i));    // 각 문자마다 새로운 BigChar 인스턴스 생성
        }
    }

    // 입력된 문자열을 큰 문자열로 변환하여 출력
    public void print() {
        for (BigChar bc : bigChars) {
            bc.printChar();
        }
    }
}
