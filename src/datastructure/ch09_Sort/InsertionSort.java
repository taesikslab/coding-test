package datastructure.ch09_Sort;

public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                } else
                    break;
            }
        }
    }

    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
