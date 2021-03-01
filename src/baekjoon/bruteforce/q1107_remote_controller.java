package baekjoon.bruteforce;

import java.util.Scanner;

public class q1107_remote_controller {
    /*
    1. 숫자 버튼을 누른다
    2. 그 다음에 +/- 버튼을 누른다
    3. +나 - 중 하나만 누르면 된다

    브루트포스는 문제에서 ~하라가 주어진다
    */

    static boolean[] broken = new boolean[10];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }

        // 숫자 버튼을 누르지 않는 경우로 정답의 초기값 설정
        int ans = n - 100;
        if (ans < 0) {
            ans = -ans;
        }

        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            // 이동할 수 있는지 없는지 판단
            int len = possible(c);
            if (len > 0) {
                int press = c - n;
                if (press < 0) {
                    press = -press;
                }
                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }
}
