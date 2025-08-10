package example.templatemethod.ex02.cafehook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeHook extends CaffeineBeverageHook {

    @Override
    void brew() {
        System.out.println("커피를 내리는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("시럽을 추가하는 중");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();

        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("커피에 시럽을 넣을까요? (y/n)");
        String answer = null;
        try {
            answer = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (answer == null) ? "no" : answer;
    }
}
