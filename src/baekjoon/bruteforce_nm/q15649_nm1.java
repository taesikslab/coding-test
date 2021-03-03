package baekjoon.bruteforce_nm;

import java.util.Scanner;

public class q15649_nm1 {

    static boolean[] c = new boolean[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
    }

    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false;
        }
    }
}
