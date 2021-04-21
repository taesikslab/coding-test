package exercise.datastructure_with_java;

public class q1_SelectionSort {

    /*
    선택 정렬은 배열에서 아직 정렬되지 않은 부분의 원소들 중에서 최솟값을 선택하여 정렬된 부분의 바로 오른쪽 원소와 교환하는 간단한 정렬 알고리즘이다.
    두번째 루프가 n-1번부터 1번까지 비교연산을 수행한다. 즉 O(n^2)

    1. 정렬 여부와 상관없이 항상 O(n^2)이다.
    -> 입력에 민감하지 않다.

    2. 횟솟값을 찾은 후 원소를 교환하는 횟수가 n-1번으로 가장 작은 최악경우 교환횟수이다.
    */

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) { // 배열 길이만큼 순회
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) { // min의 다음 값부터 최솟값을 찾음
                if (a[minIndex] > a[j]) minIndex = j;
            }
            swap(a, minIndex, i); // 시작했던 인덱스와 최솟값의 인덱스의 값을 교환
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
