package problem;

import java.util.Scanner;

public class Problem1992 {
  private static int N;
  private static int[][] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N][N];
    sc.nextLine();
    for (int i = 0 ;i<N;i++) {
        String s = sc.nextLine();
      for (int j = 0;j<N;j++) {
        arr[i][j] = s.charAt(j) - 48;
      }
    }
    String result = dfs(0,N-1, 0,N-1);

    System.out.println(result);
  }

  public static String dfs(int x_from, int x_to, int y_from, int y_to) {
    int res = zip(x_from, x_to, y_from, y_to);
    StringBuilder builder = new StringBuilder();
    if (res == -1) {
      builder.append("(");
      String a = dfs(x_from, cal(x_from, x_to),  y_from, cal(y_from, y_to));
      String b = dfs(x_from, cal(x_from, x_to), cal(y_from, y_to)+1, y_to);
      String c = dfs(cal(x_from, x_to)+1, x_to, y_from, cal(y_from, y_to));
      String d = dfs(cal(x_from, x_to)+1, x_to, cal(y_from, y_to)+1, y_to);
      builder.append(a);
      builder.append(b);
      builder.append(c);
      builder.append(d);
      builder.append(")");
    }else {
      builder.append(res);
    }
    return builder.toString();
  }

  private static int cal(int from, int to) {
    return from + (to-from+1)/2 -1;
  }

  public static int zip(int x_from, int x_to, int y_from, int y_to) {
    int flag = arr[x_from][y_from];
    for (int i = x_from; i<=x_to;i++) {
      for (int j= y_from;j<=y_to;j++) {
        if (flag != arr[i][j]) {
          return -1;
        }
      }
    }
    return flag;
  }

}
