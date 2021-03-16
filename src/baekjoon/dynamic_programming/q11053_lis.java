package baekjoon.dynamic_programming;

import java.util.Scanner;

public class q11053_lis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int answer = d[0];
        for (int i = 0; i < n; i++) {
            if (answer < d[i]) {
                answer = d[i];
            }
        }

        System.out.println(answer);
    }
}
