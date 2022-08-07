package problem;

import java.util.Scanner;

public class Problem11724 {
    static int N;
    static int M;
    static boolean[][] array;
    static boolean[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new boolean[N+1][N+1];
        dp = new boolean[N+1];

        for (int i = 0;i<M;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            array[x][y]=true;
            array[y][x]=true;
        }

        int cnt = 0;
        for (int i = 1 ;i<=N;i++) {
            if (dp[i]) continue;
            cnt ++;
            dfs(i);
        }
        System.out.println(cnt);
    }
    public static void dfs(int start) {

        dp[start]=true;

        for (int i = 1;i<=N;i++) {
            if (!dp[i] && array[start][i]) {
                dfs(i);
            }
        }
    }
}
