// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 NonterminalExpression에 해당
// <program> ::= program <command list>
public class ProgramNode extends Node {

    private Node commandListNode;   // <command list>에 대응되는 구조(노드)를 저장

    /* 패키지 외부의 Client가 미니 언어를 파싱할 때, 항상 ProgramNode에서만 시작 가능 */
    public ProgramNode() {
    }

    /* AbstractExpression에서 정의한 메서드 구현 - BNF로 작성한 문법 규칙대로 구문 해석 수행 */
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode(); // <command list>에 대응되는 노드 생성
        commandListNode.parse(context);
    }

    /* 현재 노드를 해석한 결과를 문자열로 반환 */
    @Override
    public String toString() {
        return String.format("[program %s]", commandListNode);
    }
}
