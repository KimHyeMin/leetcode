package problem;

import java.util.Scanner;

public class Problem2606 {
    private static int N;
    static boolean[][] network = new boolean[101][101];
    static boolean[] dp = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int n = sc.nextInt();
        for (int i = 0;i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network[a][b] = true;
            network[b][a] = true;
        }


        int num = dfs(1, 0);


        System.out.println(num-1);
    }

    private static int dfs(int from, int sum) {
        dp[from] = true;

        int currentSum = sum;
        boolean flag = false;

        for (int i = 1;i<=N;i++) {
            if (network[from][i] && !dp[i]) {
                   flag=true;
                   sum = sum + dfs(i, currentSum );
            }
        }
        if (!flag) {
            return 1;
        }
        return sum + 1;
    }
}
