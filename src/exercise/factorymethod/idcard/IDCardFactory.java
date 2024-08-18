package exercise.factorymethod.idcard;

import exercise.factorymethod.framework.Factory;
import exercise.factorymethod.framework.Product;

public class IDCardFactory extends Factory {

    private int serial = 100;

    // 멀티스레드로 동작 시 다른 인스턴스에 동일한 일련번호가 붙는 것을 방지하기 위해 동기화
    @Override
    public synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    public void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
