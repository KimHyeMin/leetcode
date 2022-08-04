package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 양궁대회2 {
    int N;
    private int maxScore=-100;
    List<int[]> array = new ArrayList<>();
    private int[] appeach;

    public int[] solution(int n, int[] info) {
        N=n;appeach=info;
        int[] ryanUse = new int[11];

        dfs(0, 0, ryanUse);

        if (array.isEmpty()) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        return findMinimum(array);
    }

    private int[] findMinimum(List<int[]> results) {
        Collections.sort(results, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return results.get(0);
    }

    //target 0일때 10점
    private void dfs(int target, int round, int[] ryan) {
        //과녁점수, 라운드, 라이언, 어피치

        if (target == 10 || round == N) {                    //마지막 과녁 또는 마지막 라운드
            ryan[target] = N-round;
            int diff = calculatePoint(appeach, ryan);

            if (diff <= 0) {
                //라이어인 졌어
                ryan[target] = 0;
                return;
            }
            if (maxScore <= diff) {
                if (maxScore < diff) {
                    maxScore = diff;
                    array.clear();
                }
                array.add(deepCopy(ryan));
            }
            return;
        } else{

        }
    }

    private int[] deepCopy(int[] ryan) {
        int[] newArray = new int[11];
        System.arraycopy(ryan, 0, newArray, 0, 11);
        return newArray;
    }


    public int calculatePoint(int[] apeachInfo, int[] lionInfo) {
        int apeach = 0;
        int lion = 0;
        for (int i = 0;i<apeachInfo.length;i++) {
            if (apeachInfo[i]>0 && (apeachInfo[i] >= lionInfo[i])) {
                apeach += (10-i);
            }

            if (apeachInfo[i] < lionInfo[i]) {
                lion += (10-i);
            }
        }
        return lion-apeach;
    }

}
