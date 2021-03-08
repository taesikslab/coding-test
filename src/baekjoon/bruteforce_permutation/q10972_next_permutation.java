package baekjoon.bruteforce_permutation;

import java.util.Scanner;

public class q10972_next_permutation {

    public static boolean next_permutation(int[] a) {
        // 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        // 마지막 순열이므로 return한다
        if (i <= 0) {
            return false;
        }

        // 2. j ≥ i 이면서 A[j] > A[i-1] 를 만족하는 가장 큰 j를 찾는다
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        // 3. A[i-1]과 A[j]를 swap 한다
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4. A[i]부터 순열을 뒤집는다
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (next_permutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}