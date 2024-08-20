package exercise.singleton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// TripleEnum을 클래스 형태로 나타낸 코드
public class TripleClass {

    // 이름이 "ALPHA", "BETA", "GAMMA"인 인스턴스를 생성하고, 생성한 인스턴스를 이름에 매핑
    // 이름에 매핑된 인스턴스에 관한 주어진 Map은 재할당 불가
    private static final Map<String, TripleClass> map = new HashMap<>();
    static {
        String[] names = {"ALPHA", "BETA", "GAMMA"};
        Arrays.stream(names).forEach(string -> map.put(string, new TripleClass(string)));
    }

    private final String name;

    private TripleClass(String name) {
        System.out.println("The instance " + name + " is created");
        this.name = name;
    }

    // 지정한 이름이 가리키는 인스턴스를 반환
    // TripleEnum.getInstance 메서드와 동일한 역할 수행
    public static TripleClass getInstance(String name) {
        return map.get(name);
    }

    // 인스턴스 출력 시 해당 인스턴스의 이름을 출력
    @Override
    public String toString() {
        return this.name;
    }
}
