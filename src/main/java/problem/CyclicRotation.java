package problem;

import java.util.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int[] answer = new int[A.length];
        int len = A.length;

        if (len==0) {
            return answer;
        }

        if (K >= len) {
            K = K%len;
        }

        int index = K;
        for (int i=0;i<A.length;i++) {
            answer[index++] = A[i];
            if (index>=A.length) index = index%A.length;
        }

        return answer;
    }

    public static void main(String[] args) {
        CyclicRotation dut = new CyclicRotation();
//        System.out.println(dut.convert(1041));
        int[] input = {};
        int k = 6;
        Arrays.stream(dut.solution(input, k)).forEach(it -> System.out.println(it));
    }
}
