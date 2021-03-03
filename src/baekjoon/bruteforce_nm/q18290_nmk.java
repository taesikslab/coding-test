package baekjoon.bruteforce_nm;

import java.util.Scanner;

public class q18290_nmk {

    static int[][] a = new int[10][10];
    static boolean[][] c = new boolean[10][10];
    static int n, m, k;
    static int ans = -2147483647;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void go(int px, int py, int cnt, int sum) {
        if (cnt == k) {
            if (ans < sum) ans = sum;
            return;
        }
        for (int x = px; x < n; x++) {
            for (int y = (x == px ? py : 0); y < m; y++) {
                if (c[x][y]) continue;
                boolean ok = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (c[nx][ny]) ok = false;
                    }
                }
                if (ok) {
                    c[x][y] = true;
                    go(x, y, cnt + 1, sum + a[x][y]);
                    c[x][y] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        go(0, 0, 0, 0);
        System.out.println(ans);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static void go_row_major_order(int prev, int cnt, int sum) {
        if (cnt == k) {
            if (ans < sum) ans = sum;
            return;
        }
        for (int j=prev+1; j<n*m; j++) {
            int x = j/m;
            int y = j%m;
            if (c[x][y]) continue;
            boolean ok = true;
            for (int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (c[nx][ny]) ok = false;
                }
            }
            if (ok) {
                c[x][y] = true;
                go_row_major_order(x*m+y, cnt+1, sum+a[x][y]);
                c[x][y] = false;
            }
        }
    }
    public static void main2(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        go_row_major_order(-1, 0, 0);
        System.out.println(ans);
    }
}


