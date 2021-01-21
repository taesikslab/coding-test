package inflearnjava.stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length())
            return result;

        int[] patArr = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            int[] txtArr = new int[256];
            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)]++;
            }

            if (Arrays.equals(patArr, txtArr)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if(patArr[i] != txtArr[i]) return false;
        }
        return true;
    }
}
