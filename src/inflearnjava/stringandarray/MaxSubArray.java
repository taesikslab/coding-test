package inflearnjava.stringandarray;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 1, 2, -1}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -1, 0, -4}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, sum);
        }

        return max;
    }
}
