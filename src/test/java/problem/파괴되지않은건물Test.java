package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class 파괴되지않은건물Test {
    파괴되지않은건물 dut = new 파괴되지않은건물();

    @Test
    public void test() {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skills= {{1,0,0,3,4,4},{1,0,1,3,3,1},{2,1,0,3,1,2},{1,2,0,2,3,2}};
        int actual = dut.solution(board, skills);

        System.out.println(actual);
    }

    @Test
    public void test2() {
        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][]skills= {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        int actual = dut.solution(board, skills);

        System.out.println(actual);
    }

}