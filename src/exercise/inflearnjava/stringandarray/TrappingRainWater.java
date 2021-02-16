package exercise.inflearnjava.stringandarray;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solve(nums));
    }

    private static int solve(int[] bars) {
        int answer = 0;
        int[] leftMaxArr = new int[bars.length];
        int[] rightMaxArr = new int[bars.length];

        int leftMax = 0;
        for (int i = 0; i < bars.length; i++) {
            leftMaxArr[i] = leftMax;
            if (bars[i] > leftMax)
                leftMax = bars[i];
        }

        int rightMax = 0;
        for (int i = bars.length - 1; i >= 0; i--) {
            rightMaxArr[i] = rightMax;
            if (bars[i] > rightMax)
                rightMax = bars[i];
        }

        for (int i = 0; i < bars.length; i++) {
            int max = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if (max > bars[i])
                answer += max - bars[i];
        }

        return answer;
    }
}
