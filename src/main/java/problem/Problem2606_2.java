package problem;

import java.util.Scanner;

public class Problem2606_2 {
    private static int N;
    static boolean[][] network = new boolean[101][101];
    static boolean[] dp = new boolean[101];
    static int cnt = 0;

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


        dfs(1);


        System.out.println(cnt);
    }

    private static void dfs(int from) {
        dp[from] = true;

        for (int i = 1;i<=N;i++) {
            if (network[from][i] && !dp[i]) {
                cnt++;
                dfs(i );
            }
        }
    }
}
