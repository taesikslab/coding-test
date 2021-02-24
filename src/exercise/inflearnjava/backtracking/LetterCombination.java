package exercise.inflearnjava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public static void main(String[] args) {
        System.out.println(solve("23"));
    }

    private static List<String> solve(String digits) {
        String[] digitLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combine(result, digitLetter[digits.charAt(i) - '0']);
        }

        return result;
    }

    private static List<String> combine(List<String> list, String digit) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++) {
            for (String s : list) {
                result.add(s + digit.charAt(i));
            }
        }

        return result;
    }
}
