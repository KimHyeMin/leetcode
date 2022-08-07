package problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class problem2667 {

    static int N;
    static boolean[][] apart = new boolean[26][26];
    static boolean[][] dp = new boolean[26][26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<N;i++) {
            String str = sc.nextLine();
            for (int j=0;j<str.length();j++) {
                apart[i][j] = str.charAt(j) == '1';
            }
        }
        int num = 0;
        List<Integer> apartCnt = new ArrayList<>();
        for (int i =0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!apart[i][j] || dp[i][j])continue;

                int cnt = dfs(i, j, 0);

                num++;
                apartCnt.add(cnt);

            }
        }
        System.out.println(num);
        apartCnt.sort(Comparator.naturalOrder());
        for (Integer cnt : apartCnt) {
            System.out.println(cnt);
        }
    }

    public static int dfs(int x, int y, int sum){
        dp[x][y] = true;
        int csum = sum;
        if (x+1<N && apart[x+1][y] && !dp[x+1][y]) {
            sum = sum + dfs(x+1, y, csum);
        }
        if (x-1>=0 && apart[x-1][y] && !dp[x-1][y]) {
            sum = sum + dfs(x-1, y, csum);
        }
        if (y+1<N && apart[x][y+1] && !dp[x][y+1]) {
            sum = sum + dfs(x, y+1, csum);
        }
        if (y-1>=0 && apart[x][y-1] && !dp[x][y-1]) {
            sum = sum + dfs(x, y-1, csum);
        }
        return sum+1;
    }
}
