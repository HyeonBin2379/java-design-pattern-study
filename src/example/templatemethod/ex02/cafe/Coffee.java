package example.templatemethod.ex02.cafe;

public class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("커피를 내리는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("시럽을 추가하는 중");
    }
}
