package datastructure.ch09_Sort;

public class HeapSort {

    public void sort(int[] a) {
        int heapSize = a.length - 1;
        for (int i = heapSize / 2; i > 0; i--) {
            downheap(a, i, heapSize);
        }

        while (heapSize > 1) {
            swap(a, 1, heapSize--); // 가장 큰 값을 가진 원소와 마지막 원소 교환 + 힙 사이즈 감소
            downheap(a, 1, heapSize);
        }
    }

    private void downheap(int[] a, int i, int heapSize) {
        while (2 * i <= heapSize) {
            int j = 2 * i; // j는 i의 왼쪽 자식
            if (j < heapSize && a[j] < a[j + 1]) j++; // 오른쪽 자식이 큰 경우
            if (a[i] > a[j]) break; // 힙속성을 만족하면 멈춤
            swap(a, i, j); // 힙속성을 만족하지 않으면 부모(i)와 자식 승자(j)를 교환
            i = j; // 부모 자리를 자식 승자 자리로 바꿈
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
