package exercise.factorymethod.framework;

public abstract class Factory {

    public abstract Product createProduct(String owner);
    public abstract void registerProduct(Product product);
}
