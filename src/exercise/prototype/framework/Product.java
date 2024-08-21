package exercise.prototype.framework;

public abstract class Product implements Cloneable {

    public abstract void use(String s);
    public final Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }
}
