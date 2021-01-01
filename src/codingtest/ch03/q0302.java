package codingtest.ch03;

import java.util.Arrays;
import java.util.Scanner;

public class q0302 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        int first = numbers[n - 1];
        int second = numbers[n - 2];

        int answer = 0;

        int x = (m % k) * k;
        int y = m / k;
        answer = x * first + y * second;

        System.out.println(answer);
    }
}
