package problem;

import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Arrays;

import static org.junit.Assert.*;

public class 주차요금Test {

    @Test
    public void test() {
        LocalTime inTime = LocalTime.of(5,34);
        LocalTime outTime = LocalTime.of(7, 59);

        LocalTime total = outTime.minusHours(inTime.getHour()).minusMinutes(inTime.getMinute());
        int time = total.getHour()*60 + total.getMinute();
        System.out.println(time);
        System.out.println(total.toSecondOfDay()/60);
        System.out.println(total.getHour());
    }

    private static final 주차요금 dut = new 주차요금();

    @Test
    public void test2() {
        int[] fees = {180, 5000, 10, 600};
        String[] history = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = dut.solution(fees, history);

        Arrays.stream(solution).forEach(it -> System.out.println(it));
    }

}