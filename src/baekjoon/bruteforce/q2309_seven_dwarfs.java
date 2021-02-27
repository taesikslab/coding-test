package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class q2309_seven_dwarfs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] h = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            sum += h[i];
        }

        Arrays.sort(h);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum - h[i] - h[j] == 100) {
                    for (int k = 0; k < n; k++) {
                        if( k == i || k == j) {
                            continue;
                        }
                        System.out.println(h[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
