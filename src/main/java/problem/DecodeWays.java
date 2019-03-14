package problem;

public class DecodeWays {

    public int numDecodings(String s) {

        int[] arr = new int[s.length()];

        decide1(s, 0, arr);

        if (s.length() == 1) {
            return arr[0];
        }

        decide1(s, 1, arr);
        decide2(s, 1, arr);

        if (s.length() == 2) {
            return arr[1];
        }

        for (int i=2;i<s.length();i++) {
            decide1(s, i, arr); //자기 자신
            decide2(s, i, arr);
        }

        return arr[s.length()-1];
    }

    private void decide2(String s, int i, int[] arr) {
        int aa = (s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48);
        if (s.charAt(i - 1) != '0' && aa > 0 && aa <=26) {
            arr[i] = arr[i] + (i-2 < 0 ? 1 : arr[i-2]);
        }
    }

    private void decide1(String s, Integer i, int[] arr) {
        if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
            arr[i] = arr[i] + (i-1 < 0 ? 1 : arr[i-1]);
        }
    }

}
