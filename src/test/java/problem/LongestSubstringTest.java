package problem;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LongestSubstringTest {

    private LongestSubstring dut = new LongestSubstring();

    @Test
    public void input() throws Exception {
        String input1 = "abcabcbb";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(3));
    }

    @Test
    public void input2() throws Exception {
        String input1 = "bbbbb";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(1));
    }

    @Test
    public void input3() throws Exception {
        String input1 = "pwwkew";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(3));
    }

    @Test
    public void input4() throws Exception {
        String input1 = " ";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(1));
    }

    @Test
    public void input5() throws Exception {
        String input1 = "dvdf";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(3));
    }

    @Test
    public void input6() throws Exception {
        String input1 = "abcdefg";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(7));
    }

    @Test
    public void input7() throws Exception {
        String input1 = "";
        int acutal = dut.lengthOfLongestSubstring(input1);

        assertThat(acutal, is(0));
    }
}