package codingtest.ch11;

import java.util.Arrays;
import java.util.Scanner;

public class q03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        System.out.println(Arrays.toString(arr));

        int[] group = new int[1000000];
        group[0] = arr[0];

    }
}
