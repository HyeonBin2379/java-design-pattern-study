package exercise.factorymethod.idcard;

import exercise.factorymethod.framework.Factory;
import exercise.factorymethod.framework.Product;

public class IDCardFactory extends Factory {

    private int serial = 100;

    // 일련번호 부여 시 멀티스레드 환경에서 생성된 다른 인스턴스에 동일한 번호가 붙지 않도록
    // 동기화를 적용하는 것이 좋음
    @Override
    public synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    public void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
