package problem;


import java.util.HashMap;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0 ; i< 200 ; i ++ ){

            char target = 0;
            int count = 0;
            for (String str : strs) {
                if (i >= str.length()) {
                    break;
                }

                if (target == 0) {
                    count = count + 1;
                    target = str.charAt(i);
                } else {
                    if (target == str.charAt(i)) {
                        count = count + 1;
                    } else {
                        break;
                    }
                }
            }
            if (count > 0 && count == strs.length) {
                resultBuilder.append(target);
            } else {
                break;
            }
        }


        return resultBuilder.toString();
    }
}
