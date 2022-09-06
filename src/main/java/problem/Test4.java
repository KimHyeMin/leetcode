package problem;
import java.util.*;


public class Test4 {

  int solution(int[] A, int[] B) {
    int n = A.length;
    int m = B.length;;
    Arrays.sort(A);
    Arrays.sort(B);
    int i = 0;
    for (int k = 0; k < n; k++) {
      while (i < m - 1 && B[i] < A[k])
        i += 1;
      if (A[k] == B[i])
        return A[k];
    }
    return -1;
  }

  public static void main(String[] args) {
      Test4 dut = new Test4();
      int[] A = {2,2,2,3,9,10};
      int[] B = {1,1,1,4,5,6,7,8,9};
      System.out.println(dut.solution(A, B));
  }
}
