package example.prototype.framework;

import java.util.HashMap;
import java.util.Map;

// Prototype 패턴의 Client에 해당
public class Manager {

    // 복제하여 사용할 인스턴스의 원형을 저장
    private final Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    // ConcretePrototype이 되는 클래스 이름 대신 메서드를 사용하여 인스턴스를 복제,
    // ConcretePrototype과 Client 간 결합도를 낮춤
    public Product create(String prototypeName) {
        Product prototype = showcase.get(prototypeName);
        return prototype.createCopy();      // 인스턴스의 복제본을 반환
    }
}
