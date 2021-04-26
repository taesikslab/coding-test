package codinginterview.arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class q11_중복이없는가 {
    public static void main(String[] args) {
        q11_중복이없는가 q = new q11_중복이없는가();
        System.out.println(q.checkDuplicates(""));
        System.out.println(q.checkDuplicates("aa"));
        System.out.println(q.checkDuplicates("abc"));
        System.out.println(q.checkDuplicates("abca"));
        System.out.println(q.checkDuplicates("1231"));
    }

    private boolean checkDuplicates(String s) {
        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.toCharArray()[i]);
        }
        return set.size() != s.length();
    }

    // ================================================================================================================
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
}