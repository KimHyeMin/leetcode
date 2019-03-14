package problem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DecodeWaysTest {

    private DecodeWays dut = new DecodeWays();

    @Test
    public void input6() throws Exception {
        int i = dut.numDecodings("0");

        assertThat(i, is(0));
    }

    @Test
    public void input2() throws Exception {
        int i = dut.numDecodings("12");

        assertThat(i, is(2));
    }

    @Test
    public void input3() throws Exception {
        int i = dut.numDecodings("10");

        assertThat(i, is(1));
    }

    @Test
    public void input10() throws Exception {
        int i = dut.numDecodings("27");

        assertThat(i, is(1));
    }

    @Test
    public void input1() throws Exception {
        int i = dut.numDecodings("226");

        assertThat(i, is(3));

    }

    @Test
    public void input4() throws Exception {
        int i = dut.numDecodings("101");

        assertThat(i, is(1));
    }



    @Test
    public void input7() throws Exception {
        int i = dut.numDecodings("111");

        assertThat(i, is(3));
    }

    @Test
    public void input8() throws Exception {
        int i = dut.numDecodings("012");

        assertThat(i, is(0));
    }

    @Test
    public void input9() throws Exception {
        int i = dut.numDecodings("230");

        assertThat(i, is(0));
    }

    @Test
    public void input11() throws Exception {
        int i = dut.numDecodings("027");

        assertThat(i, is(0));
    }

    @Test
    public void input12() throws Exception {
        int i = dut.numDecodings("227");

        assertThat(i, is(2));
    }

    @Test
    public void input14() throws Exception {
        int i = dut.numDecodings("102");

        assertThat(i, is(1));
    }

    @Test
    public void input5() throws Exception {
        int i = dut.numDecodings("1010");

        assertThat(i, is(1));
    }


    @Test
    public void input13() throws Exception {
        int i = dut.numDecodings("1029");

        assertThat(i, is(1));
    }
}