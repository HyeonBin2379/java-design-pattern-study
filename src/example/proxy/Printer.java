package example.proxy;

// Proxy 패턴에서의 RealSubject에 해당
public class Printer implements Printable {

    private String name;

    public Printer() {
        heavyJob("Printer 인스턴스 생성 중...");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob(String.format("Printer 인스턴스(%s) 생성 중...", name));
    }

    /* Subject에 정의된 메서드들을 구현 */
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    // 처리 시간이 오래 걸리는 작업
    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.print(".");
        }
        System.out.println("완료");
    }
}
