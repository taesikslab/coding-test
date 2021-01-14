package inflearnjava.stringandarray;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
                System.out.println("index " + index);
            }
        }

        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
