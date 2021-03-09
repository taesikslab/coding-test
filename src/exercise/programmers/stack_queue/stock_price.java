package exercise.programmers.stack_queue;

import java.util.Arrays;

public class stock_price {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}