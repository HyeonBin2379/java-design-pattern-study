package example.visitor;

public class Main {

    public static void main(String[] args) {
        // 루트디렉토리 계층 생성
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("latex", 20000));
        binDir.add(new File("vi", 10000));

        // 루트디렉토리 이하 각 파일마다 방문하여 경로와 크기를 출력
        rootDir.accept(new ListVisitor());
        System.out.println();

        // 사용자 디렉토리 계층 생성 후 루트 디렉토리 계층에 추가
        System.out.println("Making user entries...");
        Directory alice = new Directory("alice");
        Directory bob = new Directory("bob");
        Directory john = new Directory("john");
        usrDir.add(alice);
        usrDir.add(bob);
        usrDir.add(john);
        alice.add(new File("diary.html", 100));
        alice.add(new File("Composite.java", 200));
        bob.add(new File("memo.txt", 300));
        bob.add(new File("index.html", 350));
        john.add(new File("game.exe", 400));
        john.add(new File("junk.mail", 500));

        // 루트디렉토리 이하 각 파일마다 방문하여 경로와 크기를 출력
        rootDir.accept(new ListVisitor());
        System.out.println();

        // 확장자가 .html인 파일을 루트 디렉토리 계층에서 탐색하고 출력
        FileFindVisitor ffv = new FileFindVisitor(".html");
        rootDir.accept(ffv);
        System.out.println("HTML files are:");
        for (File file : ffv.getFoundFiles()) {
            System.out.println(file);
        }
    }
}
