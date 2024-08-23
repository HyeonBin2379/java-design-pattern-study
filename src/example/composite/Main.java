package example.composite;

// Composite 패턴에서의 Client에 해당
public class Main {

    public static void main(String[] args) {
        // 루트디렉토리 계층 생성 후 출력
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        rootDir.printList();

        // Composite 패턴을 활용하여 구한 파일의 절대경로를 출력
        System.out.println();

        // 루트디렉토리 계층에 사용자별 디렉토리를 새로 추가한 후 출력
        System.out.println("Making user entries...");
        Directory alice = new Directory("alice");
        Directory bob = new Directory("bob");
        Directory john = new Directory("john");
        usrDir.add(alice);
        usrDir.add(bob);
        usrDir.add(john);

        File file = new File("Composite.java", 200);
        alice.add(file);
        alice.add(new File("diary.html", 100));
        bob.add(new File("memo.txt", 300));
        john.add(new File("game.exe", 400));
        john.add(new File("junk.mail", 500));

        // 루트디렉토리 이하 모든 디렉토리 및 파일 출력
        rootDir.printList();
        System.out.println();

        // 지정한 파일의 전체 경로 출력
        System.out.println("file = " + file.getFullName());
        System.out.println("john = " + john.getFullName());
    }
}
