package problem;

import java.util.*;
import java.util.stream.Collectors;

public class DemoSolution {

    public int solution(int[] A) {
        int[] inputs = Arrays
                .stream(A)
                .filter(num -> num > 0)
                .sorted()
                .toArray();

        if (inputs.length == 0) {
            return 1;
        }

        int a = 1;
        for (int i = 0; i < inputs.length; i++) {
            if (a == inputs[i]) a++;
            else return a;
        }
        return a;
    }

    public static void main(String[] args) {
        DemoSolution a = new DemoSolution();
        int[] b = {-1, -3};
        System.out.println(a.solution(b));
    }
}
