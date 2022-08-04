package problem;

import org.junit.Test;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class k진수에서소수개수구하기Test {

    k진수에서소수개수구하기 dut = new k진수에서소수개수구하기();


    @Test
    public void test() {
        String reversedConverted = "110101020112";


        List<Integer> numberList = new ArrayList<>();
        int number = 0;
        for (int i = 0;i<reversedConverted.length();i++) {
            if (reversedConverted.charAt(i) == '0') {
                numberList.add(number);
                //init
                number = 0;
            } else {
                number = number*(number == 0 ? 0 : 10) + (reversedConverted.charAt(i)-48);
            }
        }
        //마무리
        if (number > 0) {
            numberList.add(number);
        }

        numberList.stream().forEach(it -> System.out.println(it));
    }

    @Test
    public void test2() {
        System.out.println(dut.solution(437674, 3));
    }

    @Test
    public void test3() {
        System.out.println(dut.solution(110011, 10));
    }
}