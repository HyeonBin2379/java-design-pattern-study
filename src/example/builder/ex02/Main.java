package example.builder.ex02;

public class Main {

    public static void main(String[] args) {
        ConcreteBuilder1 builder1 = new ConcreteBuilder1();
        Director director = new Director(builder1);
        String[] data1 = {"feature1", "feature2", "feature3"};
        director.make("simple", data1);
        System.out.println(builder1.getResult());
        System.out.println();

        ConcreteBuilder2 builder2 = new ConcreteBuilder2();
        String[] data2 = {"featureA", "featureB", "featureC"};
        director.changeBuilder(builder2);
        director.make("complex", data2);
        System.out.println(builder2.getResult());
    }
}
