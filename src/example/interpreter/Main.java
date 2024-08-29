package example.interpreter;

import example.interpreter.minilang.Context;
import example.interpreter.minilang.Node;
import example.interpreter.minilang.ProgramNode;
import java.nio.file.Files;
import java.nio.file.Path;

// Interpreter 패턴에서의 Client - 실행용 샘플 코드
// Client는 인터프리터 외부에서 인터프리터를 실행
public class Main {

    // 작성된 미니 프로그램의 코드가 저장된 디렉토리 경로
    private static final String DIRECTORY_PATH = "src/example/interpreter/";

    public static void main(String[] args) {
        try {
            // Client에서는 구문 해석과 어휘 분석을 위해 ProgramNode와 Context 사용
            for (String text : Files.readAllLines(Path.of(DIRECTORY_PATH + "program.txt"))) {
                System.out.printf("text = \"%s\"\n", text);
                Node node = new ProgramNode();  // 구문 트리 조립을 위해 루트 노드 생성
                node.parse(new Context(text));
                // 작성한 코드를 한 줄씩 해석한 결과를 문자열로 출력
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
