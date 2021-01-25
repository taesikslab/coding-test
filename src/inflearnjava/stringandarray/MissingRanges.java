package inflearnjava.stringandarray;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(solve(nums, lower, upper));
        // [0->1, 4, 6->49, 51->74, 76->99]
        System.out.println(solve(new int[]{0, 1, 3, 50, 75}, lower, upper));
    }

    public static List<String> solve(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        String arrowSign = "->";

        if (nums[0] > lower) {
            int val = nums[0] - lower;
            if (val == 1) result.add(String.valueOf(nums[0] - 1));
            if (val > 1) result.add(lower + arrowSign + (nums[0] - 1));
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int val = nums[i + 1] - nums[i];
            if (val == 2) result.add(String.valueOf(nums[i + 1] - 1));
            if (val > 2) result.add((nums[i] + 1) + arrowSign + (nums[i + 1] - 1));

        }

        int val = upper - nums[nums.length - 1];
        if (val == 1) result.add(String.valueOf(upper));
        if (val > 1) result.add((nums[nums.length - 1] + 1) + arrowSign + upper);

        return result;
    }

    // ==================================================================================================

    public static List<String> solve2(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            result.add(showRange(lower,upper));
            return result;
        }

        // 1st step
        if (lower < nums[0]){
            result.add(showRange(lower,nums[0]-1));
        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] != nums[i+1] && nums[i] +1 < nums[i+1] ) {
                result.add(showRange(nums[i]+1, nums[i+1]-1));
            }
        }

        // 3rd step
        if (nums[nums.length-1] < upper){
            result.add(showRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    public static String showRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);

    }
}

