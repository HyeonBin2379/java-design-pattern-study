// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// Interpreter 패턴에서의 Context에 해당
// 어휘 분석(lex)과 구문 해석(parse) 중 어휘 해석을 담당
public class Context {

    private final String[] tokens;  // 생성된 토큰들
    private String lastToken;       // 마지막으로 접근한 토큰
    private int index;              // 현재 토큰이 저장된 위치

    /* Client*/
    // 작성된 미니 언어 코드에서 공백 문자를 제외한 모든 숫자, 문자(열)을 토큰으로 변환
    public Context(String text) {
        this.tokens = text.split("\\s+");
        this.index = 0;
        nextToken();
    }

    // 다음 토큰으로 진행
    public String nextToken() {
        return lastToken = (index < tokens.length) ? tokens[index++] : null;
    }

    // 현재 토큰을 반환
    public String currentToken() {
        return lastToken;
    }

    // 현재 토큰 체크 후 그 다음 토큰으로 진행
    public void skipToken(String token) throws ParseException {
        if (currentToken() == null) {   // 현재 토큰이 존재하지 않음
            throw new ParseException(String.format("Error: '%s' is expected, "
                    + "but no more token is found.\n", token));
        } else if (!token.equals(currentToken())) { // 현재 토큰의 이름이 지정한 이름과 다른 경우(문법 규칙에 위배되는 코드)
            throw new ParseException(String.format("Error: '%s' is expected, "
                    + "but '%s' is found.\n", token, currentToken()));
        }
        nextToken();
    }

    // 현재 토큰이 숫자면 정수로 변환
    public int currentNumber() throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: No more token.");
        }
        int number;
        try {
            number = Integer.parseInt(currentToken());  // 정수 변환
        } catch (NumberFormatException e) {
            throw new ParseException("Error: " + e);
        }
        return number;
    }
}
