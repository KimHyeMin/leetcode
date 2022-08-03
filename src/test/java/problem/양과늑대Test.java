package problem;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class 양과늑대Test {

    private static final 양과늑대2 dut2 = new 양과늑대2();
    private static final 양과늑대 dut = new 양과늑대();

    @Test
    public void test() {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
//        int solution = dut.solution(info, edges);
//        assertThat(solution, is(5));
//        System.out.println(solution);
        int solution2 = dut2.solution(info, edges);
        assertThat(solution2, is(5));
        System.out.println(solution2);
    }

    @Test
    public void test1() {
        int[][] array1 = {{10, 20}, {30, 40}, {50, 60}, {70, 80}};

        int[][] array2 = Arrays.copyOf(array1, array1.length);
        array2[0][0] = 99;

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.println("array2 position [" + i + "][" + j + "] : " + array2[i][j]);
                System.out.println("array1 position [" + i + "][" + j + "] : " + array1[i][j]);

            }
        }
    }

    @Test
    public void test3() {
        양과늑대.Sheep sheep = new 양과늑대.Sheep(2,2,1);
        양과늑대.Sheep sheep2 = new 양과늑대.Sheep(0,3,1);
        System.out.println(sheep.compareTo(sheep2));
    }

    @Test
    public void test5() {
//        boolean[][] arr = new boolean[2][3];
//        양과늑대2.Sheep sheep = new 양과늑대2.Sheep(0,2,0, arr);
//        양과늑대2.Sheep sheep2 = new 양과늑대2.Sheep(0,2,1, arr);
//        assertThat(sheep.compareTo(sheep2) == 1, is(true));
        boolean[][] arr = new boolean[2][3];
        양과늑대2.Node sheep = new 양과늑대2.Node(2,1);
        양과늑대2.Node sheep2 = new 양과늑대2.Node(2,0);
        assertThat(sheep.compareTo(sheep2), is(-1));
    }
}