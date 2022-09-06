package problem;

public class Test1 {

  public String solution(int U, int L, int[] C) {
    // write your code in Java SE 8
    int N  = C.length;

    StringBuilder[] array = new StringBuilder[2];
    array[0] = new StringBuilder();
    array[1] = new StringBuilder();

    for (int i = 0; i < N ; i++) {
        if (C[i] == 2) {
          U = U - 1;
          L = L - 1;
          array[0].append("1");
          array[1].append("1");
        } else if (C[i] == 0) {
          array[0].append("0");
          array[1].append("0");
        } else {
          if (U >= 1) {
            U = U-1;
            array[0].append("1");
            array[1].append("0");
          } else {
            L = L-1;
            array[0].append("0");
            array[1].append("1");
          }
        }

        if (U < 0 || L < 0) {
          return "IMPOSSIBLE";
        }
    }

    return array[0].append(",").append(array[1]).toString();
  }

  public static void main(String[] args) {
    Test1 a = new Test1();
    int[] input = {};
    System.out.println(a.solution(0, 0 , input));
  }
}
