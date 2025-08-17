package example.builder.ex02;

public class ConcreteBuilder2 implements Builder {

    private Product2 result;

    @Override
    public void reset() {
        this.result = new Product2();
    }

    @Override
    public void buildStepA(String featureA) {
        System.out.println("ConcreteBuilder2.buildStepA: " + featureA);
        result.setFeatureA(featureA);
    }

    @Override
    public void buildStepB(String featureB) {
        System.out.println("ConcreteBuilder2.buildStepB: " + featureB);
        result.setFeatureB(featureB);
    }

    @Override
    public void buildStepC(String featureC) {
        System.out.println("ConcreteBuilder2.buildStepC: " + featureC);
        result.setFeatureC(featureC);
    }

    public Product2 getResult() {
        return result;
    }
}
