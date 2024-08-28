package example.proxy;

// Proxy 패턴을 이용하는 외부의 Client에 해당
public class Main {

    public static void main(String[] args) {
        // Proxy 생성 후 실행 - Proxy 스스로 처리 가능한 작업인 경우
        Printable p = new PrinterProxy("Alice", "example.proxy.Printer");
        System.out.println("Proxy에서 바로 처리:");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        System.out.println();

        // Proxy가 RealSubject에서의 처리를 요청 - Proxy가 처리 불가능한 작업인 경우
        p.setPrinterName("Bob");
        System.out.println("RealSubject로 처리:");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.print("Hello, World.");   // RealSubject만 처리 가능
        System.out.println();
    }
}