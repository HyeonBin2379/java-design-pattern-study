package example.builder.ex02;

public class Product1 {

    private String featureA;
    private String featureB;
    private String featureC;

    public void setFeatureA(String featureA) {
        this.featureA = featureA;
    }

    public void setFeatureB(String featureB) {
        this.featureB = featureB;
    }

    public void setFeatureC(String featureC) {
        this.featureC = featureC;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "featureA='" + featureA + '\'' +
                ", featureB='" + featureB + '\'' +
                ", featureC='" + featureC + '\'' +
                '}';
    }
}
