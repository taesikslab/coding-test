package datastructure.ch08_Heap;

public class MinHeapTree {

    private int[] heap;
    private int size; // tree의 사이즈를 의미
    private int pointer;

    public MinHeapTree(int size) {
        this.size = size;
        this.heap = new int[size + 1];
        heap[0] = -1;
        pointer = 0;
    }

    public int getRoot() {
        return heap[1];
    }

    public int getParentIndex(int index) {
        if (index < 1) {
            return -1;
        }
        return index / 2;
    }

    public int getLeftChildIndex(int index) {
        if (index < 1) {
            return -1;
        }
        return index * 2;
    }

    public int getRightChildIndex(int index) {
        if (index < 1) {
            return -1;
        }
        return index * 2 + 1;
    }

    public boolean isLeafNode(int index) {
        return getLeftChildIndex(index) > size && getRightChildIndex(index) > size;
    }

    public void swap(int currentIndex, int parentIndex) {
        int temp;
        temp = heap[currentIndex];
        heap[currentIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    public void insert(int value) {
        heap[++pointer] = value;
        int currentIndex = pointer;
        while (heap[currentIndex] < heap[getParentIndex(currentIndex)]) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public int delete() {
        int min = getRoot();
        heap[0] = heap[size];
        heap[size] = -1;
        size--;
        if (size > 1) {
            rebuild(1);
        }
        return min;
    }

    private void rebuild(int current) {
        /*
        current index 기준으로 왼쪽 자식과 오른쪽 자식 중 작은 값을 구한다.
           - 왼쪽 자식만 존재하는 경우
           - 양쪽 자식 모두 존재하는 경우
             current index 기준으로 왼쪽 자식과 오른쪽 자식 중 작은 값을 구한다.
        current가 swap값보다 크면 자리를 바꾼다.
        */

        if (isLeafNode(current)) return;
        int leftChildIndex = getLeftChildIndex(current);
        int rightChildIndex = getRightChildIndex(current);

        int swapIndex = current;
        if (rightChildIndex > size) {
            if (heap[leftChildIndex] < heap[current]) {
                swapIndex = leftChildIndex;
            }
        } else {
            if (heap[leftChildIndex] <= heap[rightChildIndex]) {
                swapIndex = leftChildIndex;
            } else {
                swapIndex = rightChildIndex;
            }
        }

        if (heap[current] > heap[swapIndex]) {
            swap(current, swapIndex);
            rebuild(swapIndex);
        }
    }
}
