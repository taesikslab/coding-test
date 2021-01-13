package codingtest.ch11;

import java.util.Scanner;

public class q05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] warr = new int[n];
        for (int i = 0; i < n; i++) {
            warr[i] = sc.nextInt();
        }

        // nc2에서 무게가 같은 경우만 빼주면 되지 않나
        // nc2 - 시그마 kc2(k=무게가 같은 공의 개수)
    }
}
