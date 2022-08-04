package problem;

public class 양궁대회3 {
    int N;
    private int maxScore=0;
    int[] dp;
    private int[] appeach;
    private int[] ryanUse;

    public int[] solution(int n, int[] info) {
        N=n;appeach=info;
        ryanUse = new int[11];
        dp = new int[11];

        dfs(0, n);

        if (maxScore == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        return ryanUse;
    }

    //과녁점수, 화살쏜 갯수,
    private void dfs(int score, int count) {
        dp[10-score] = count;
        calculatePoint(); //answer 도출

        for (int s = score;s<=10;s++) {
            dp[10-s] = 0;
        }

        if (score >= 10) {
            return;
        }

        for (int left = 1; left <=count;left++) {
            dp[10-score] = count-left;
            dfs(score+1, left);
        }
    }

    private int[] deepCopy(int[] ryan) {
        int[] newArray = new int[11];
        System.arraycopy(ryan, 0, newArray, 0, 11);
        return newArray;
    }


    public void calculatePoint() {
        int apeachN = 0;
        int lionN = 0;
        for (int i = 0;i<11;i++) {
            if (appeach[i]>0 && (appeach[i] >= dp[i])) {
                apeachN += (10-i);
            }

            if (appeach[i] < dp[i]) {
                lionN += (10-i);
            }
        }
        int diff = lionN - apeachN;
        if (maxScore < diff) {
            maxScore = diff;
            ryanUse = deepCopy(dp);
        }
    }

}
