package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    private static final LongestCommonPrefix dut = new LongestCommonPrefix();

    @Test
    public void test() {
        String[] input = {"d","d","d"};
        String s = dut.longestCommonPrefix(input);
        System.out.println(s);
    }
}