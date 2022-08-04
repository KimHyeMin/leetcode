package problem;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class 양궁대회Test {

    private 양궁대회 dut = new 양궁대회();

    @Test
    public void test() {
        int[] input = {2,1,1,1,0,0,0,0,0,0,0};
        int[] solution = dut.solution(5, input);

        for (int i : solution) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        int[] apeach = {2,1,1,1,0,0,0,0,0,0,0};
        int[] lion = {3,2,0,0,0,0,0,0,0,0,0};

        //23
//        assertThat(dut.calculateLionPoint(apeach, lion), is(13));
//        assertThat(dut.calculateApeachPoint(apeach, lion ), is(13));
        System.out.println(dut.calculateLionPoint(apeach, lion));
        System.out.println(dut.calculateApeachPoint(apeach, lion));
    }

    @Test
    public void test3() {
        int[] input = {0,0,0,0,0,0,0,0,3,4,3};
        int[] solution = dut.solution(10, input);

        for (int i : solution) {
            System.out.println(i);
        }
    }

}