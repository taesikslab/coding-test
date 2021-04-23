package exercise.datastructure_with_java;

public class q5_MergeSortExercise {

    public void sort(int[] a) {
        int[] b = new int[a.length];
        sort(a, b, 0, a.length - 1);
    }

    private void sort(int[] a, int[] b, int low, int high) {
        if (low > high) return;

        int mid = low + (low + high) / 2;
        sort(a, b, low, mid);
        sort(a, b, mid + 1, high);
        merge(a, b, low, mid, high);
    }

    private void merge(int[] a, int[] b, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high ; k++) {

        }
    }
}
