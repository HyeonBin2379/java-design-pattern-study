package example.proxy;

// Proxy 패턴에서의 Proxy에 해당
// Proxy는 RealSubject를 대리하기 때문에 저장된 정보는 RealSubject와 항상 동일해야 함
public class PrinterProxy implements Printable {

    private String name;
    private Printable real;
    private final String className;

    public PrinterProxy(String name, String className) {
        this.name = name;
        this.real = null;
        this.className = className;
    }

    /* 아래는 Subject에 정의된 메서드들을 구현,
       Proxy의 일부 메서드는 RealSubject에게 처리를 위임하는 식으로 커스터마이징 */

    /* 이 메서드를 동기화함으로써 멀티스레드의 각 스레드마다 이 메서드를 호출했을 때
       Proxy에서의 name 필드와 RealSubject의 name 필드 값이 서로 달라지는 문제를 방지 */
    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    /* Proxy가 처리할 수 없는 작업일 때 RealSubject를 생성 */
    /* 이 메서드를 동기화함으로써 멀티스레드에서 각 스레드마다 이 메서드를 호출했을 때
       PrintProxy에서의 real 필드의 값 판단과 값 변경이 제각각 수행되는 것을 방지 */
    private synchronized void realize() {
        if (real == null) {
            try {
                // RealSubject는 프로그램 실행 도중에 생성
                real = (Printable) Class.forName(className).getDeclaredConstructor().newInstance();
                real.setPrinterName(name);
            } catch (ClassNotFoundException e) {
                System.out.println("클래스 " + className + "가 발견되지 않았습니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
