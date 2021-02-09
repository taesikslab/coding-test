package inflearnjava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis_dfs(n));
    }

    public static List<String> generateParenthesis_dfs(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    private static void dfs(List<String> result, String str, int left, int right) {
        if (left < 0 || left > right) return;

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        dfs(result, str + '(', left - 1, right);
        dfs(result, str + ')', left, right - 1);
    }
}
