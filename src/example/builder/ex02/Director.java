package example.builder.ex02;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    public void make(String type, String[] data) {
        System.out.println("type = " + type);
        builder.reset();

        builder.buildStepA(data[0]);
        if (type.equals("simple")) {
            return;
        }
        builder.buildStepB(data[1]);
        builder.buildStepC(data[2]);
    }
}
