package baekjoon.dynamic_programming;

import java.util.Scanner;

public class q9095_add123 {

    /*
    DP 시간복잡도 = 전체 문제의 개수 x  문제 1개를 푸는 시간
    */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    d[i] += d[i - j];
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
