// 미니 언어 인터프리터 관련 코드를 저장하는 패키지
package example.interpreter.minilang;

// 구문 해석 중 발생한 오류에 관한 예외
public class ParseException extends Exception {

    public ParseException(String message) {
        super(message);
    }
}
