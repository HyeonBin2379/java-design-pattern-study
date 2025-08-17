package example.builder.ex02;

public class ConcreteBuilder1 implements Builder {

    private Product1 result;

    @Override
    public void reset() {
        System.out.println("ConcreteBuilder1.reset");
        this.result = new Product1();
    }

    @Override
    public void buildStepA(String featureA) {
        System.out.println("ConcreteBuilder1.buildStepA: " + featureA);
        result.setFeatureA(featureA);
    }

    @Override
    public void buildStepB(String featureB) {
        System.out.println("ConcreteBuilder1.buildStepB: " + featureB);
        result.setFeatureB(featureB);
    }

    @Override
    public void buildStepC(String featureC) {
        System.out.println("ConcreteBuilder1.buildStepC: " + featureC);
        result.setFeatureC(featureC);
    }

    public Product1 getResult() {
        return this.result;
    }
}
