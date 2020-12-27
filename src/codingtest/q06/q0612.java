package codingtest.q06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q0612 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Integer[] aList = new Integer[n];
        for (int i = 0; i < n; i++) {
            aList[i] = scanner.nextInt();
        }

        Integer[] bList = new Integer[n];
        for (int i = 0; i < n; i++) {
            bList[i] = scanner.nextInt();
        }

        Arrays.sort(aList);
        Arrays.sort(bList, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) sum += bList[i];
            else sum += aList[i];
        }

        System.out.println(sum);
    }
}
