package inflearnjava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        dfs(result, list, nums, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> cur, int[] nums, int start) {
        List<Integer> list = new ArrayList<>(cur);
        result.add(list);

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(result, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
