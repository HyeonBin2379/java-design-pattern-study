package example.builder.ex02;

public interface Builder {

    void reset();
    void buildStepA(String featureA);
    void buildStepB(String featureB);
    void buildStepC(String featureC);
}
