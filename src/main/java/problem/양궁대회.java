package problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 양궁대회 {


    public int[] solution(int n, int[] info) {

        Queue<Score> queue = new ArrayDeque<>();
        for (int i =0 ;i<info.length;i++) {
            int[] lionInfo = new int[info.length];
            lionInfo[i]=1;
            queue.add(Score.of(i, 1, lionInfo)); // 0점 1라운드
        }

        List<int[]> array = new ArrayList<>();
        int maxBetween = 0;

        while(!queue.isEmpty()) {
            Score head = queue.poll();

            if (head.round > n) {
                continue;
            }

            int apeachPoint = calculateApeachPoint(info, head.lionInfo);
            int lionPoint = calculateLionPoint(info, head.lionInfo);

            if (head.round == n && apeachPoint>=lionPoint) {
                continue;
            }

            if (apeachPoint < lionPoint) {
                head.lionInfo[10] = head.lionInfo[10] + (n-head.round);
                int diff = lionPoint - apeachPoint;
                if (diff >= maxBetween) {
                    array.clear();
                    array.add(head.lionInfo);
                    maxBetween = diff;
                }
                continue;
            }

            for (int i =0 ; i<info.length;i++) {
                int[] newArray = new int[info.length];
                System.arraycopy(head.lionInfo, 0, newArray, 0, info.length);
                newArray[i] = newArray[i] + 1;
                queue.add(new Score(i, head.round+1, newArray));
            }
        }
        int[] answer;
        if (array.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else{
            answer = findMinimum(array);
        }
        return answer;
    }

    private int[] findMinimum(List<int[]> results) {
        int[] answer = null;
        long min = 99999999999l;

        for (int[] result : results) {
            long per = 1l;
            long temp = 0;
            for (int i = result.length -1; i>=0 ;i--) {
                //0, 1, 2, 3, 4, 5, 6, 7, 8
                temp = temp + per*result[i];
                per*=10;
            }
            if (min > temp) {
                min = temp;
                answer = result;
            }
        }
        return answer;
    }

    public int calculateLionPoint(int[] apeachInfo, int[] lionInfo) {
        int num = 0;
        for (int i = 0;i<apeachInfo.length;i++) {
            if (apeachInfo[i] < lionInfo[i]) {
                num += (10-i);
            }
        }
        return num;
    }

    public int calculateApeachPoint(int[] apeachInfo, int[] lionInfo) {
        int num = 0;
        for (int i = 0;i<apeachInfo.length;i++) {
            if (apeachInfo[i]>0 && (apeachInfo[i] >= lionInfo[i])) {

                num += (10-i);
            }
        }
        return num;
    }

    public static class Score {
        int point;
        int round;
        int[] lionInfo;

        public Score(int point, int i2, int[] lionInfo) {
            this.point = point;
            this.round = i2;
            this.lionInfo = lionInfo;
        }

        public static Score of(int point, int round, int[] lionInfo) {
            Score score = new Score(point, round, lionInfo);
            return score;
        }
    }
}
