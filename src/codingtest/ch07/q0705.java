package codingtest.ch07;

import java.util.Arrays;
import java.util.Scanner;

public class q0705 {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int target : targets) {
            if (binarySearch(arr, target, 0, n - 1) == -1) System.out.print("no ");
            else System.out.print("yes ");
        }
    }
}
