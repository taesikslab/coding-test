package thisiscodingtest.ch11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());
        System.out.println(Arrays.toString(coins));

        int max = Arrays.stream(coins).mapToInt(Integer::intValue).sum();
        int min = 0;
        for (int i = 1; i <= max + 1; i++) {
            int current = i;
            for (Integer coin : coins) {
                if (current - coin < 0) {
                    continue;
                } else if (current - coin == 0) {
                    current = 0;
                    break;
                } else {
                    current -= coin;
                }
            }
            if (current != 0) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }
}
