package problem;

import java.util.List;
import java.util.function.Function;

public class 파괴되지않은건물 {

    public int solution(int[][] board, int[][] skill) {
        int[][] markingSum = new int[board.length+1][board[0].length+1];


        for (int i =0 ; i<skill.length;i++) {
            int type = skill[i][0], x_1 = skill[i][1], y_1 = skill[i][2], x_2 = skill[i][3], y_2 = skill[i][4], degree = skill[i][5];
            int degree_t = type == 1 ? degree * -1 : degree;
            markingSum[x_1][y_1] = markingSum[x_1][y_1] + degree_t;
            markingSum[x_1][y_2+1] = markingSum[x_1][y_2+1] + degree_t * -1;
            markingSum[x_2+1][y_1] = markingSum[x_2+1][y_1] + degree_t* -1;
            markingSum[x_2+1][y_2+1] = markingSum[x_2+1][y_2+1] + degree_t ;
        }

        //위에서 아래로 누적합
        for (int i =0;i<=board[0].length;i++) {
            for (int j = 1 ;j<=board.length;j++) {
                markingSum[j][i] = markingSum[j][i] + markingSum[j-1][i];
            }
        }

        //왼쪽에서 오른쪽으로 누적합
        for (int i =0;i<=board.length;i++) {
            for (int j = 1 ;j<=board[0].length;j++) {
                markingSum[i][j] = markingSum[i][j] + markingSum[i][j-1];
            }
        }



        int answer =0;
        for (int i =0;i<board.length;i++) {
            for (int j =0;j<board[0].length;j++) {
                if(board[i][j] + markingSum[i][j] > 0) {
                    answer ++;
                }
            }
        }

        return answer;
    }

}
