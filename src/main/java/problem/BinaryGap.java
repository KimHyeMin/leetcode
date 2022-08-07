package problem;

public class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        String binary = convert(N);

        int gap = 0;
        int maxSize = 0;
        boolean flag = false;
        for (int i = 0;i<binary.length();i++) {
            if (binary.charAt(i) == '1') {
                if (!flag) {
                    flag = true;
                } else {
                    if (gap > 0) {
                        if (maxSize < gap) {
                            maxSize = gap;
                        }
                    }
                    gap = 0;
                }
            } else if (binary.charAt(i) == '0') {
                if (flag) {
                    gap ++;
                }
            }
        }
        return maxSize;
    }

    private String convert(int n) {
        StringBuilder builder = new StringBuilder();
        while(n>0) {
            builder.append(n%2);
            n=n/2;
        }
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        BinaryGap dut = new BinaryGap();
//        System.out.println(dut.convert(1041));
        System.out.println(dut.solution(15));
    }
}
