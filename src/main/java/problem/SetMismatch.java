package problem;


public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] flag = new int[nums.length+1];

        for (int i =0 ; i< nums.length; i ++) {
            flag[nums[i]] = flag[nums[i]] + 1;
        }

        for (int i =1 ; i<= nums.length; i++) {
            if (flag[i] == 0) {
                res[1] = i;
            }
            if (flag[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
