package baekjoon.dynamic_programming_2;

import java.util.Scanner;

public class q11722_가장긴감소부분수열 {

    // D[i] = A[i]에서 끝나는 가장 긴 감소하는 부분 수열의 길이
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (a[j] > a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int ans = d[1];
        for (int i = 2; i <= n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }

    // D[i] = A[i]에서 시작하는 가장 긴 감소하는 부분 수열의 길이
    public static void main2(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = n; i >= 1; i--) {
            d[i] = 1;
            for (int j = i + 1; j <= n; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int ans = d[1];
        for (int i = 2; i <= n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}
