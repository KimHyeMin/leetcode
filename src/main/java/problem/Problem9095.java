package problem;

import java.io.IOException;
import java.util.Scanner;

//https://www.acmicpc.net/problem/9095
public class Problem9095 {
    private static final int[] db = new int[12];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        db[1] = 1;
        db[2] = 2;
        db[3] = 4;

        for (int j = 4; j <= 10; j++) {
            db[j] = db[j-1] + db[j-2] + db[j-3];
        }

        for(int i = 0;i<T;i++) {
            int n = sc.nextInt();
            System.out.println(db[n]);
        }
    }
}
