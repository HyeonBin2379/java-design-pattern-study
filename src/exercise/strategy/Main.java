package exercise.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "E", "A", "C");

        list.sort(String::compareTo);
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
