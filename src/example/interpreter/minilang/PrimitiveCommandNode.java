// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 TerminalExpression에 해당
// <primitive command> ::= go | left | right
class PrimitiveCommandNode extends Node {

    private String name;

    /* 패키지 외부의 Client는 이 노드를 직접 생성할 수 없음 */
    PrimitiveCommandNode() {
    }

    /* AbstractExpression에서 정의한 메서드 구현 - BNF로 작성한 문법 규칙대로 구문 해석 수행 */
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        if (name == null) { // 현재 토큰이 존재하지 않음
            throw new ParseException("Error: missing <primitive command>");
        }
        // 지정한 키워드 이외의 다른 문자열이 사용된 경우 문법 규칙에 위배
        else if (!name.equals("go") && !name.equals("left") && !name.equals("right")) {
            throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
        }
        context.skipToken(name);
    }

    /* 현재 노드를 해석한 결과를 문자열로 반환 */
    @Override
    public String toString() {
        return name;
    }
}
