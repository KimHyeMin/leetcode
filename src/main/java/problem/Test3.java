package problem;

import java.util.HashSet;
import java.util.Set;

public class Test3 {

  public int solution(int[] A) {
    int answer = 0;
    Set<Integer> checked = new HashSet<>();

    for (int num : A) {

      if (Math.abs(num) < answer) continue;

      if (checked.contains(-1 * num)) {
        answer = Math.max(answer, Math.abs(num));
      } else {
        checked.add(num);
      }
    }
    return answer;
  }


  public static void main(String[] args) {
    Test3 dut = new Test3();
    int[] input = {4,-4,1,-1,-5,5};
    System.out.println(dut.solution(input));
  }
}
