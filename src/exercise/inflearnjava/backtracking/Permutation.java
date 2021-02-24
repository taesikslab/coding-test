package exercise.inflearnjava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute_dfs(nums));
    }

    public static List<List<Integer>> permute_dfs(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        dfs(nums, result, list);
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur) {
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            result.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i]))
                continue;
            cur.add(nums[i]);
            dfs(nums, result, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
