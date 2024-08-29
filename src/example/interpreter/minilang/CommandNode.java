// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 NonterminalExpression에 해당
// <command> ::= <repeat command> | <primitive command>
class CommandNode extends Node {

    /* <command list>, <repeat command>, <primitive command> 모두 저장 가능 */
    private Node node;

    /* 패키지 외부의 Client는 이 노드를 직접 생성할 수 없음 */
    CommandNode() {
    }

    /* AbstractExpression에서 정의한 메서드 구현 - BNF로 작성한 문법 규칙대로 구문 해석 수행 */
    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode(); // <repeat command>에 해당되는 노드 저장 후 구문 해석 재개
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();  // <primitive command>에 해당되는 노드 저장 후 구문 해석 재개
            node.parse(context);
        }
    }

    /* 현재 노드를 해석한 결과를 문자열로 반환 */
    @Override
    public String toString() {
        return node.toString();
    }
}