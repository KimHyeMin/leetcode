package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class 양궁대회2Test {

    @Test
    public void test() {

//        for i in range(1 << 11): //# 2048가지의 경우에 대하여 탐색
//        for j in range(11):
//        if (1 << j) & i:


        for(int bitmask = 0; bitmask < (1<<11); bitmask++) {
            for (int j =0 ;j<11;j++) {

            }
        }
    }

    private 양궁대회3 dut = new 양궁대회3();
//    @Test
//    public void test3() {
//        int[] apeach = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] lion = {0,2,2,0,1,0,0,0,0,0,0};
//        System.out.println(dut.calculatePoint(apeach, lion));
//    }

    @Test
    public void test2() {
        int[] input = {2,1,1,1,0,0,0,0,0,0,0};
        int[] solution = dut.solution(5, input);

        for (int i : solution) {
            System.out.println(i);
        }
    }

}