package problem;

import java.util.Scanner;

public class Problem2098 {

    private static int N;
    private static int[][] array;
    private static boolean[] dp = new boolean[16];
    private static int min = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N][N];
        for (int i =0;i<N;i++) {
            for(int j = 0 ; j<N;j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0;i<N;i++) {
            dfs(i, i, 0, 0);
        }

        System.out.println(min);
    }

    public static void dfs(int start, int node, int sum, int nodeCnt) {

        if (nodeCnt == N && start == node) {
            if (min > sum) {
                min=sum;
            }
            return;
        }

        for (int i = 0;i<N;i++) {
            if (array[node][i] == 0) continue;

            if (array[node][i] > 0 && !dp[i]) {
                dp[i]= true;
                int sum1 = sum + array[node][i];
                if (sum1 < min) {
                    dfs(start, i, sum1, nodeCnt+1);
                }
                dp[i]=false;
            }
        }
    }
}
