package example.decorator;

import java.util.ArrayList;
import java.util.List;

// Decorator 패턴의 ConcreteComponent에 해당
public class MultiStringDisplay extends Display{

    private final List<String> body = new ArrayList<>();
    private int columns = 0;

    // 문자열 추가 후 한 행의 최대 문자열 길이 갱신
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) {
            columns = msg.length();
        }
        updatePadding();
    }

    /* Decorator 패턴의 Component인 Display에 정의된 추상 메서드를 구현 */

    @Override
    public int getColumns() {   // 가로 문자 수
        return columns;
    }

    @Override
    public int getRows() {      // 세로 행 수
        return body.size();
    }

    @Override
    public String getRowText(int row) { // 한 행에서의 문자열
        return body.get(row);
    }


    // 출력할 문자열의 오른쪽 여백 추가
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            int padding = columns - line.length();
            if (padding > 0) {
                body.set(row, line + spaces(padding));
            }
        }
    }

    // 지정한 길이만큼의 공백 추가
    private String spaces(int count) {
        return " ".repeat(Math.max(0, count));
    }
}
