package problem;

import java.util.ArrayList;
import java.util.List;

public class k진수에서소수개수구하기 {

    public int solution(int n, int k) {

        String converted = converted(n, k);

        List<Long> numberList = getNumberList(converted);
        int answer = 0;
        for (Long num : numberList) {
            if (PrimeFilter.isPrime(num)) {
                answer ++;
            }
        }
        return answer;
    }

    private List<Long> getNumberList(String converted) {
        List<Long> numberList = new ArrayList<>();
        String[] split = converted.split("0");

        for (String s : split) {
            if (!s.isEmpty())
                numberList.add(Long.parseLong(s));
        }

        return numberList;
    }

    public String converted(int n, int k) {
        StringBuilder builder = new StringBuilder();
        int temp = n;
        while(temp>0) {
            builder.append(temp % k);
            temp = temp/k;
        }
        return builder.reverse().toString();
    }

    public static class PrimeFilter {

        public static boolean isPrime(long num) {
            if (num == 2 || num == 3) return true; //  # 2 or 3 은 소수
            if (num % 2 == 0 || num < 2) return false; //  # 2의 배수이거나 2보다 작은 값인 경우 소수가 아님

            for(int i = 3; i <= Math.sqrt(num); i++)
                if(num % i == 0)
                    return false;
            return true;
        }
    }
}
