package exercise.inflearnjava.stringandarray;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    // index를 활용
    private static void moveZeros(int[] nums) {
        int newIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            nums[newIndex] = nums[i];
            newIndex++;
        }

        for (int i = newIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
