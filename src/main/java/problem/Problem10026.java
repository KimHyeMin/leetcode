package problem;

import java.util.Scanner;

public class Problem10026 {

    private static int N;
    private static char[][] array;
    private static boolean[][] dp;
    private static boolean[][] dp2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new char[N][N];
        dp = new boolean[N][N];
        dp2 = new boolean[N][N];
        sc.nextLine();

        for(int i = 0; i<N;i++) {
            String line = sc.nextLine();
            for (int j=0;j<line.length();j++) {
                array[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;

        for (int i =0 ;i<N;i++) {
            for(int j= 0 ;j<N;j++) {
                if (!dp[i][j]) {
                    cnt ++;
                    dfs(i,j, array[i][j]);
                }
            }
        }
        int cnt_2 = 0;
        for (int i =0 ;i<N;i++) {
            for(int j= 0 ;j<N;j++) {
                if (!dp2[i][j]) {
                    cnt_2 ++;
                    dfs2(i,j, array[i][j]);
                }
            }
        }
        System.out.println(cnt + " " + cnt_2);
    }
    public static void dfs(int x, int y, char color) {
        dp[x][y] = true;

        if (x+1<N && !dp[x + 1][y] && array[x+1][y] == color) {
            dfs(x + 1, y, color);
        }

        if (y + 1<N && !dp[x][y+1] && array[x][y+1] == color) {
            dfs(x, y + 1, color);
        }

        if (x-1>=0 && !dp[x - 1][y] && array[x - 1][y] == color) {
            dfs(x - 1, y, color);
        }

        if (y-1>=0 && !dp[x][y-1] && array[x][y-1] == color) {
            dfs(x, y-1, color);
        }
    }

    private static boolean sameColor(int x, int y, char color) {
        if ('R' == color || 'G' == color) {
            if (array[x][y] == 'R' || array[x][y] == 'G') {
                return true;
            }
            return false;
        }
        return array[x][y] == color;
    }

    public static void dfs2(int x, int y, char color) {
        dp2[x][y] = true;

        if (x+1<N && !dp2[x + 1][y] && sameColor(x + 1, y, color)) {
            dfs2(x + 1, y, color);
        }

        if (y + 1<N && !dp2[x][y+1] && sameColor(x , y+1, color)) {
            dfs2(x, y + 1, color);
        }

        if (x-1>=0 && !dp2[x - 1][y] &&sameColor(x - 1, y, color)) {
            dfs2(x - 1, y, color);
        }

        if (y-1>=0 && !dp2[x][y-1] && sameColor(x , y-1, color)) {
            dfs2(x, y-1, color);
        }
    }
}
