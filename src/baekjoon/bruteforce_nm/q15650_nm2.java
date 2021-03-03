package baekjoon.bruteforce_nm;

import java.util.Scanner;

public class q15650_nm2 {

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
            if (index > 0 && a[index - 1] > i) continue;
            c[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void go_start(int index, int start, int n, int m) {
        if (index == m) {
            for (int i=0; i<m; i++) {
                System.out.print(a[i]);
                if (i != m-1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i=start; i<=n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go_start(index+1, i+1, n, m);
            c[i] = false;
        }
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go_start(0,1,n,m);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void go_select(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i=0; i<m; i++) {
                System.out.print(a[i]);
                if (i != m-1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        if (index > n) return;
        a[selected] = index;
        go_select(index+1, selected+1, n, m);
        a[selected] = 0;
        go_select(index+1, selected, n, m);
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go_select(1, 0, n, m);
    }
}