package example.proxy;

// Proxy 패턴에서의 Subject에 해당
public interface Printable {

    /* Proxy와 RealSubject를 동일시하기 위한 메서드들을 정의 */
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
