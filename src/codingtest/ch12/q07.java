package codingtest.ch12;

public class q07 {

    public static void main(String[] args) {
        System.out.println(solve(123402));
        System.out.println(solve(7755));
    }

    private static String solve(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        int mid = length / 2;

        int leftSum = 0;
        for (int i = 0; i < mid; i++) {
            char c = s.charAt(i);
            leftSum += c - '0';
        }

        int rightSum = 0;
        for (int i = mid; i < length; i++) {
            char c = s.charAt(i);
            rightSum += c - '0';
        }

        if (leftSum == rightSum) {
            return "LUCKY";
        }
        return "READY";
    }
}
