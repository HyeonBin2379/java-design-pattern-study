package example.templatemethod.ex02;

import example.templatemethod.ex02.cafe.CaffeineBeverage;
import example.templatemethod.ex02.cafe.Coffee;
import example.templatemethod.ex02.cafe.Tea;
import example.templatemethod.ex02.cafehook.CaffeineBeverageHook;
import example.templatemethod.ex02.cafehook.CoffeeHook;
import example.templatemethod.ex02.cafehook.TeaHook;

public class Client {

    public static void main(String[] args) {
        CaffeineBeverage tea1 = new Tea();
        CaffeineBeverage coffee1 = new Coffee();
        tea1.prepareRecipe();
        coffee1.prepareRecipe();

        CaffeineBeverageHook tea2 = new TeaHook();
        CaffeineBeverageHook coffee2 = new CoffeeHook();
        tea2.prepareRecipe();
        coffee2.prepareRecipe();
    }
}
