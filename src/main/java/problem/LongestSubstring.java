package problem;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();

        int first = 0, end = 0 , max = 0;

        for (int i = 0; i < s.length();i++) {

            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), i);
                end = i;
            } else {
                //dddd
                int len = end - first + 1;

                if (max < len) {
                    max = len;
                }
                first = map.get(s.charAt(i))+1;
                end = i;
                init(s, map, first, end);
            }
        }

        int len = s.length() == 0 ? 0 : end - first + 1;
        return max < len ? len : max;
    }

    private void init(String s, HashMap<Character, Integer> map, int first, int end) {
        map.clear();

        for (int i = first ; i <= end ; i++) {
            map.put(s.charAt(i), i);
        }
    }
}
