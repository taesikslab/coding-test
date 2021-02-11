package exercise.inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{7, 2, 11, 15}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] anwser = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            int secondNumber = target - firstNumber;
            if (map.containsKey(secondNumber)) {
                anwser[0] = i;
                anwser[1] = map.get(secondNumber);
            }
        }

        return anwser;
    }
}
