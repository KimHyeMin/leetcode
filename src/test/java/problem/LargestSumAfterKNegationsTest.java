package problem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSumAfterKNegationsTest {

    private LargestSumAfterKNegations dut = new LargestSumAfterKNegations();

    @Test
    public void input1() throws Exception {
        int [] input = {4,2,3};
        int k = 1;
        int res = dut.largestSumAfterKNegations(input, k);

        assertThat(res, Is.is(5));
    }

    @Test
    public void input2() throws Exception {
        int [] input = {3,-1,0,2};
        int k = 3;
        int res = dut.largestSumAfterKNegations(input, k);

        assertThat(res, Is.is(6));
    }

    @Test
    public void input3() throws Exception {
        int [] input = {2,-3,-1,5,-4};
        int k = 2;
        int res = dut.largestSumAfterKNegations(input, k);

        assertThat(res, Is.is(13));
    }
}