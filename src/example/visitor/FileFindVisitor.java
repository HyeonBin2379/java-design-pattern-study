package example.visitor;

import java.util.ArrayList;
import java.util.List;

// Visitor 패턴에서 ConcreteVisitor에 해당
public class FileFindVisitor implements Visitor {

    private final String fileType;
    private final List<File> foundFiles = new ArrayList<>();

    // 탐색할 확장자를 지정
    public FileFindVisitor(String fileType) {
        this.fileType = fileType;
    }

    // 발견한 파일을 반환
    public Iterable<File> getFoundFiles() {
        return foundFiles;
    }

    /* Visitor 패턴에 정의된 visit 메서드를 구현 */
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(fileType)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (Entry entry : directory) {
            entry.accept(this);
        }
    }
}
