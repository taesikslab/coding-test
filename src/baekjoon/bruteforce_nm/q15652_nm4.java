package baekjoon.bruteforce_nm;

import java.util.Scanner;

public class q15652_nm4 {

    static boolean[] c = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(0, 1, n, m));
        System.out.println(go_select(1, 0, n, m));
    }

    static int[] a = new int[10];

    static StringBuilder go(int index, int start, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(a[i]);
                if (i != m - 1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= n; i++) {
            //if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            ans.append(go(index + 1, i, n, m));
            c[i] = false;
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static int[] cnt = new int[10];

    static StringBuilder go_select(int index, int selected, int n, int m) {
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=cnt[i]; j++) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index > n) return ans;
        for (int i=m-selected; i>=1; i--) {
            cnt[index] = i;
            ans.append(go_select(index+1, selected+i, n, m));
        }
        cnt[index] = 0;
        ans.append(go_select(index+1, selected, n, m));
        return ans;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(1, 0, n, m));
    }
}
