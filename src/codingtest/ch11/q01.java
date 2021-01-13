package codingtest.ch11;

import java.util.Scanner;

public class q01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] fear = new int[n + 2];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            fear[arr[i]]++;
        }

        int group = 0;
        for (int i = 1; i <= n; i++) {
            group += fear[i] / i;
            int rest = fear[i] % i;
            fear[i + 1] += rest;
        }

        System.out.println(group);
    }
}
