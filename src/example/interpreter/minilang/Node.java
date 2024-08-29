// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 AbstractExpression에 해당
public abstract class Node {

    /* 구문 트리의 각 노드는 공통적으로 구문 해석 처리를 위한 메서드를 정의 */
    public abstract void parse(Context context) throws ParseException;
}
