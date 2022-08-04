package problem;

import java.io.IOException;
import java.util.Scanner;

public class Problem1182 {
    public static int[] array;
    public static int num, target ;
    public static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        target = sc.nextInt();
        array = new int[num];

        for (int i = 0 ; i < num;i++) {
            int input = sc.nextInt();
            array[i] = input;
        }
        dfs(0, 0);

        if (target == 0) cnt--;

        System.out.println(cnt);
    }

    private static void dfs(int sum, int index) {

        if (index >= num) {
            if (sum == target) cnt++;
            return;
        }

        // depth번째 값을 사용하지 않는 경우
        dfs(sum, index + 1);
        // 사용하는 경우
        dfs(sum + array[index], index + 1);

    }
}
