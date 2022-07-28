package problem;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SetMismatchTest {

    private static final SetMismatch dut = new SetMismatch();

    @Test
    public void test() {
        int[] nums = {3,2,3,4,6,5};
        //2, 3, 3, 4, 5, 6
        Arrays.stream(dut.findErrorNums(nums)).forEach(it -> System.out.println(it));
    }

}