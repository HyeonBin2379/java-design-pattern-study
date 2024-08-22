package example.abstractfactory.factory;

// Abstract Factory 패턴의 AbstractFactory 역에 해당
public abstract class Factory {

    // 사용할 추상적인 공장을 생성
    public static Factory getFactory(String classname){
        Factory factory = null;
        try {
            // 지정한 이름을 갖는 ConcreteFactory의 인스턴스를 생성하여 그 상위 클래스인 AbstractFactory로 업캐스팅
            // 리플렉션 사용: 프로그램의 구성요소(클래스, 생성자)를 컴파일러가 아닌 프로그램 자신이 조작
            factory = (Factory) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factory;
    }

    // AbstractProduct 인스턴스 생성 메서드 정의
    // 반환값이 AbstractProduct 타입이므로 AbstractFactory는 ConcreteProduct를 직접 사용하지 않음
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
