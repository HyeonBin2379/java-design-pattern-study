package example.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Flyweight 패턴에서의 ConcreteFlyweight에 해당
// 이 클래스의 인스턴스는 FlyweightFactory에서 생성 후 공유
public class BigChar implements FlyweightChar {

    // 입력된 문자에 해당되는 큰 문자 파일이 저장된 디렉토리 경로
    private static final String DIRECTORY_PATH = "src/example/flyweight/bignums/";
    private String fontData;    // 큰 문자

    public BigChar(char charName) {
        try {
            // 입력한 문자에 해당되는 큰 문자 파일을 찾아 로드
            String filename = "big" + charName + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(DIRECTORY_PATH + filename))) {
                sb.append(line).append("\n");
            }
            this.fontData = sb.toString();
        } catch (IOException e) {
            // 입력한 문자에 해당되는 큰 문자 파일이 존재하지 않음
            this.fontData = charName + "?";
        }
    }

    /* FlyweightChar 인터페이스에 정의된 메서드를 구현 */
    @Override
    public void printChar() {
        System.out.print(fontData);
    }
}
