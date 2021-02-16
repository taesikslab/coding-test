package exercise.inflearnjava.stringandarray;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(solve(nums, lower, upper));
        // [0->1, 4, 6->49, 51->74, 76->99]
        System.out.println(solve(new int[]{2, 3, 50, 99}, 1, upper));
        System.out.println(solve(new int[]{3, 10, 50, 98}, 1, upper));
    }

    public static List<String> solve(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();

        if (nums[0] - lower == 1)
            answer.add(String.valueOf(lower));
        else if (nums[0] - lower > 1) {
            answer.add(toString(lower, nums[0]));
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 2)
                answer.add(String.valueOf(nums[i] - 1));
            else if (nums[i] - nums[i - 1] > 2) {
                answer.add(toString(nums[i - 1] + 1, nums[i]));
            }
        }

        if (upper - nums[nums.length - 1] == 1)
            answer.add(String.valueOf(upper));
        else if (upper - nums[nums.length - 1] > 1) {
            answer.add((nums[nums.length - 1] + 1) + "->" + upper);
        }

        return answer;
    }

    private static String toString(int small, int big) {
        return small + "->" + (big - 1);
    }
}