package exercise.prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private final Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String prototypeName) {
        Product product = showcase.get(prototypeName);
        if (product == null) {
            return null;
        }
        return product.createCopy();
    }
}
