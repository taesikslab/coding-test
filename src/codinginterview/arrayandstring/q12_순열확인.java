package codinginterview.arrayandstring;

import java.util.Arrays;

public class q12_순열확인 {

    public static void main(String[] args) {

        System.out.println(checkPermutation("dabc", "cadb"));
    }

    private static boolean checkPermutation(String s1, String s2) {
        char[] chars1 = sort(s1);
        char[] chars2 = sort(s2);

        return Arrays.equals(chars1, chars2);
    }

    private static char[] sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        return chars;
    }

    // ================================================================================================================
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }
}
