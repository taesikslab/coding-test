package codingtest.ch11;

import java.util.Arrays;

public class q06 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 0, 1}, 1)); // 3
        System.out.println(solution(new int[]{4, 3, 5, 6, 2}, 7)); // 3
        System.out.println(solution(new int[]{3, 1, 2}, 5)); // 1
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;

        int count = 0;
        for (int i = 0; i <= k + food_times.length; i++) {
            int index = count++;
            if (count == food_times.length) count = 0;

            if (i == k + food_times.length && food_times[index] == 0) {
                answer = -1;
                break;
            }

            if (i >= k && food_times[index] != 0) {
                answer = index + 1;
                break;
            }

            if (food_times[index] == 0) {
                i--;
                continue;
            }

            food_times[index]--;


            System.out.println(Arrays.toString(food_times));
        }

        return answer;
    }
}
