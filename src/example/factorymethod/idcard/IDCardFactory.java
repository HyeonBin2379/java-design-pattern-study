package example.factorymethod.idcard;

import example.factorymethod.framework.Factory;
import example.factorymethod.framework.Product;

// Factory Method 패턴에서의 ConcreteCreator에 해당
public class IDCardFactory extends Factory {

    // 아래의 두 메서드는 Creator에서 정의된 추상 메서드를 구현
    // Creator에 구현된 ConcreteProduct 인스턴스 생성용 템플릿 메서드 실행 시
    // 이 메서드들을 템플릿 메서드의 코드에 적용
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.printf(product + "을 등록했습니다.\n");
    }
}
