package exercise.datastructure_with_java;

public class q6_QuickSortExcercise {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low > high) return;
        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a, p + 1, high);
    }

    private static int partition(int[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        int p = a[pivot];

        while (true) {
            while (a[++i] < p) if (i == high) break;
            while (a[--j] > p) if (i == pivot) break;
            if (j <= i) break;
            swap(a, i, j);
        }

        swap(a, pivot, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
