package problem;

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean valid = false;

        for (int i = 1 ; i <= s.length() ; i++) {
            int idx = s.length() - i;

            if (!valid && s.charAt(idx) == ' ') {
                continue;
            } else if (valid && s.charAt(idx) == ' ') {
                break;
            }
            if (s.charAt(idx) != ' ') {
                length += 1;
                valid = true;
            }
        }

        return length;
    }
}
