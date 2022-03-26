package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        boolean ret = false;
        Set<Integer> cachedSum = new HashSet<>();
        int prevSumMod = 0;
        int curSumMod = 0;

        for (int num : nums) {
            curSumMod = (curSumMod + num) % k;

            //cachedSum.find(curSumMod) != cachedSum.end()
            if (cachedSum.contains(curSumMod)) {
                ret = true;
                break;
            }

            cachedSum.add(prevSumMod);
            prevSumMod = curSumMod;
        }
        return ret;
    }
}
