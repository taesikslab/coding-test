package baekjoon.math.divisor;

import java.util.Scanner;

public class q1037_divisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = sc.nextInt();
        int min = k;
        int max = k;
        for (int i = 1; i < n; i++) {
            int div = sc.nextInt();
            if (div < min) min = div;
            if (div > max) max = div;
        }

        System.out.println(min * max);
    }
}
