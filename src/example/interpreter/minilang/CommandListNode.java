// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

import java.util.ArrayList;
import java.util.List;

// Interpreter 패턴에서의 NonterminalExpression에 해당
// <command list> ::= <command>* end
class CommandListNode extends Node {

    /* <command list>, <repeat command>, <primitive command> 모두 저장 가능하므로 재귀적인 정의 가능*/
    private final List<Node> list = new ArrayList<>();

    /* 패키지 외부의 Client는 이 노드를 직접 생성할 수 없음 */
    CommandListNode() {
    }

    /* AbstractExpression에서 정의한 메서드 구현 - BNF로 작성한 문법 규칙대로 구문 해석 수행 */
    @Override
    public void parse(Context context) throws ParseException {
        // 0개 이상 반복되는, <command>에 대응되는 노드를 리스트 형태로 저장
        while (true) {
            if (context.currentToken() == null) {   // 작성한 미니 언어 코드가 정해진 규칙에 위배됨
                throw new ParseException("Error: Missing 'end'");
            } else if (context.currentToken().equals("end")) {  // <command list>의 끝에 도달
                context.skipToken("end");
                break;
            } else {    // <command>에 해당하는 노드를 <command list>에 추가
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    /* 현재 노드를 해석한 결과를 문자열로 반환 */
    @Override
    public String toString() {
        return list.toString();
    }
}
