package codingtest.ch08;

import java.util.Scanner;

public class q0806 {

    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] storage = new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = sc.nextInt();
        }

        d[0] = storage[0];
        d[1] = Math.max(d[1], storage[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], (d[i - 2] + storage[i]));
        }

        System.out.println(d[n - 1]);
    }
}
