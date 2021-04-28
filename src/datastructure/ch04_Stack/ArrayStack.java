package datastructure.ch04_Stack;

import java.util.EmptyStackException;

public class ArrayStack {

    private Object[] stack;
    private int top;

    public ArrayStack() {
        stack = new Object[1];
        top = -1;
    }

    public void push(Object newItem) {
        if (size() == stack.length)
            resize(2 * stack.length);
        stack[++top] = newItem;
    }

    public void resize(int newSize) {
        Object[] temp = new Object[newSize];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public Object pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }

        Object popItem = stack[top];
        stack[top--] = null;
        if (size() > 0 && size() == stack.length / 4)
            resize(stack.length / 2);
        return popItem;
    }

    public int size() {
        return top + 1; // size는 top+1임에 유의

    }
}