package datastructure.ch01_ArrayList;

import java.util.NoSuchElementException;

public class MyArrayList<E> {

    private E[] arr;
    private int size;

    public MyArrayList() {
        arr = (E[]) new Object[1];
        size = 0;
    }

    public void add(E value) {
        if (arr.length == size) {
            resize(size * 2);
        }
        arr[size - 1] = value;
    }

    private void resize(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = (E[]) newArr;
    }

    public void add(int index, E value) {
        if (arr.length == size) {
            resize(size * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    public E remove(int index) {
        if (size == 0) throw new NoSuchElementException();

        E target = arr[index];

        for (int i = index; i < size; i++) {
            arr[i] = arr[i+1];
        }
        size--;

        if(size == arr.length / 4) {
            resize(size / 2);
        }

        return target;
    }
}
