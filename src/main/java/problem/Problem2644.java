package problem;

import java.util.Scanner;

public class Problem2644 {
    static int N;
    static int A;
    static int B;
    static boolean[][] family = new boolean[101][101];
    static boolean[] dp = new boolean[101];
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0;i<n;i++) {
            int parent = sc.nextInt();
            int children = sc.nextInt();
            family[parent][children] = true;
            family[children][parent] = true;
        }

        dfs(A, 0);

        System.out.println(answer == 0 ? -1 : answer);
    }

    private static void dfs(int from, int cnt) {
        dp[from] = true;

        if (from == B) {
            answer = cnt;
            return;
        }

        for (int i =1 ;i<=N;i++) {
            if (family[from][i]) {
                if (!dp[i]) {
                    dfs(i, cnt+1);
                }
            }
        }

    }
}
