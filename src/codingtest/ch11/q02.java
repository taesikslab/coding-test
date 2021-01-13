package codingtest.ch11;

import java.util.Arrays;
import java.util.Scanner;

public class q02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(s);

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(Arrays.toString(arr));

        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            else result *= arr[i];
        }

        boolean allZero = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                allZero = false;
                break;
            }
        }

        if (allZero) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
