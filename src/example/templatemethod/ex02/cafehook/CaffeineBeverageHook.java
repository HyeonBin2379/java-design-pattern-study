package example.templatemethod.ex02.cafehook;

public abstract class CaffeineBeverageHook {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        System.out.println();
    }

    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    abstract void brew();
    abstract void addCondiments();

    // true만을 반환하는, 아무 작업이 없는 hook 메서드
    boolean customerWantsCondiments() {
        return true;
    }
}
