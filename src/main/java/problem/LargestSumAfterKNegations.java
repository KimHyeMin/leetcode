package problem;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : A) {
            queue.add(i);
        }

        while (K>0) {
            Integer smallest = queue.remove();
            queue.add(smallest*-1);
            K--;
        }

        Integer sum = 0;
        for (Integer integer : queue) {
            sum = sum + integer;
        }
        return sum;
    }
}
