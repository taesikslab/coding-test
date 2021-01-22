package inflearnjava.stringandarray;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solve(nums));
    }

    private static int solve(int[] heights) {
        int result = 0;
        if (heights == null || heights.length < 2) return result;

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        int leftMax = heights[0];
        left[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (leftMax < heights[i]) {
                left[i] = heights[i];
                leftMax = heights[i];
            } else {
                left[i] = leftMax;
            }
        }

        int rightMax = heights[heights.length - 1];
        right[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (rightMax < heights[i]) {
                right[i] = heights[i];
                rightMax = heights[i];
            } else {
                right[i] = rightMax;
            }
        }

        for (int i = 0; i < heights.length; i++) {
            result += Math.min(left[i], right[i]) - heights[i];
        }

        return result;
    }
}