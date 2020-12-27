package codingtest.q06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q0610 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

//        Arrays.sort(numbers);
//        for (int i = n; i > 0; i--) {
//            System.out.print(numbers[i-1] + " ");
//        }

        Arrays.sort(numbers, Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
