package codinginterview.arrayandstring;

import java.util.NoSuchElementException;

public class LinkedListSingle<E> {

    protected Node head;
    private int size;

    public LinkedListSingle() {
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }

    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    public void insertLast(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public static class Node<E> {

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
