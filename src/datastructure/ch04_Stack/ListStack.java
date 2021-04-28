package datastructure.ch04_Stack;

import java.util.EmptyStackException;

public class ListStack<E> {

    private Node top;

    public void ListStack() {
        top = null;
    }

    public void push(E item) {
        Node newNode = new Node(item, null);

        if (this.top == null) {
            this.top = newNode;
        }

        this.top.next = newNode;
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E popItme = (E) top.item;
        top = top.next;
        return popItme;
    }

    public class Node<E> {

        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
