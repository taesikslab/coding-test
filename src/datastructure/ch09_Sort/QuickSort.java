package datastructure.ch09_Sort;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low > high) return;

        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }

    private int partition(int[] arr, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        int p = arr[pivot];

        while (true) {
            while (arr[++i] < p) if (i == high) break;
            while (arr[--j] > p) if (j == pivot) break;
            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, pivot, j); // 피벗과 a[j] 교환
        return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
