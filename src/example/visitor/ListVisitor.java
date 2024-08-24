package example.visitor;

// Visitor 패턴에서 ConcreteVisitor에 해당
public class ListVisitor implements Visitor {

    private String currentDir = "";

    /* Visitor 패턴에 정의된 visit 메서드를 구현 */
    @Override
    public void visit(File file) {  // File의 전체 이름을 출력
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {    // Directory에 저장된 각 파일의 전체 이름을 출력
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        for (Entry entry : directory) {
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
