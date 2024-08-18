package example.factorymethod.idcard;

import example.factorymethod.framework.Factory;
import example.factorymethod.framework.Product;

public class IDCardFactory extends Factory {

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.printf(product + "을 등록했습니다.\n");
    }
}
