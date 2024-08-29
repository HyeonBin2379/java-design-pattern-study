// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 NonterminalExpression에 해당
// <repeat command> ::= repeat <number> <command list>
class RepeatCommandNode extends Node {

    private int number;             // 반복 횟수
    private Node commandListNode;   // <command list>에 대응되는 구조(노드)

    /* 패키지 외부의 Client는 이 노드를 직접 생성할 수 없음 */
    RepeatCommandNode() {
    }

    /* AbstractExpression에서 정의한 메서드 구현 - BNF로 작성한 문법 규칙대로 구문 해석 수행 */
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();   // 반복 횟수 저장
        context.nextToken();
        commandListNode = new CommandListNode();    // <command list>에 대응되는 구조(노드)를 저장
        commandListNode.parse(context);             // <command list> 구문 해석
    }

    /* 현재 노드를 해석한 결과를 문자열로 반환 */
    @Override
    public String toString() {
        return String.format("[repeat %d %s]", number, commandListNode);
    }
}
