package exercise.datastructure_with_java;

public class BinarySearchExcercise extends BinarySearch {

    @Override
    public int binarySearchRecursive(int[] a, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (a[mid] == target) return mid;
        else if (a[mid] < target) return binarySearchRecursive(a, mid + 1, right, target);
        else return binarySearchRecursive(a, left, mid - 1, target);
    }

    @Override
    public int binarySearch(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid;

        while (end >= start) {
            mid = (start + end) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
