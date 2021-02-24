package exercise.inflearnjava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(dfs(n));
    }

    private static List<String> dfs(int n) {
        List<String> result = new ArrayList<>();
        dfsHelper(result, "", n, n);
        return result;
    }

    private static void dfsHelper(List<String> result, String str, int left, int right) {
        if (left < 0 || left > right) return;

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        dfsHelper(result, str + '(', left - 1, right);
        dfsHelper(result, str + ')', left, right - 1);
    }
}
