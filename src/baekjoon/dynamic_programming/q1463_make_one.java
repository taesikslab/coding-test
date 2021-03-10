package baekjoon.dynamic_programming;

import java.util.Scanner;

public class q1463_make_one {

    public static int[] d;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(go(n));
    }

    // top-down
    public static int go(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = go(n - 1) + 1;
        if (n % 2 == 0) {
            int temp = go(n / 2) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        if (n % 3 == 0) {
            int temp = go(n / 3) + 1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }

    // bottom-up
    public static void bottom_up(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1];
        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}
