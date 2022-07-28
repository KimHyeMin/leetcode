package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthofLastWordTest {

    private static final LengthofLastWord dut = new LengthofLastWord();

    @Test
    public void test() {
        System.out.println(dut.lengthOfLastWord("a "));
    }
}