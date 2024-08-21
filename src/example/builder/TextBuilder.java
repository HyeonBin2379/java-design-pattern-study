package example.builder;

// Builder 패턴의 ConcreteBuilder에 해당
public class TextBuilder extends Builder {

    // 생성할 텍스트 파일 이름의 초기값
    private String filename = "untitled.txt";

    // 아래의 메서드들은 Builder에서 정의한 메서드 구현
    @Override
    public void makeTitle(String title) {
        filename = title + ".txt";
        sb.append("===========================\n");
        sb.append(String.format("[%s]\n\n", title));
    }

    @Override
    public void makeString(String str) {
        sb.append(String.format("■ %s\n\n", str));
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append(String.format("  · %s\n", item));
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("===========================\n");
    }

    // ConcreteBuilder는 Builder에서 정의한 메서드 이외에도 최종 결과물을 반환하는 메서드를 정의
    // Text 파일 생성 후 그 내용을 반환
    public String getTextResult() {
        makefile(filename, sb.toString());
        return sb.toString();
    }
}
