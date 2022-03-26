package problem;

import org.junit.Test;

public class ContinuousSubarraySumTest {

    @Test
    public void test() {
        ContinuousSubarraySum problem = new ContinuousSubarraySum();
        int [] ints = {23,2,6,4,7};
        int k = 13;
        System.out.println(problem.checkSubarraySum(ints, k));
    }
}