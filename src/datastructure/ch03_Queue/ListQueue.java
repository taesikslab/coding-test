package datastructure.ch03_Queue;

import java.util.NoSuchElementException;

public class ListQueue<E> {

    private Node front;
    private Node rear;
    private int size;

    public ListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(E value) {
        Node newNode = new Node(value, null);
        if (size == 0) front = newNode;
        else rear.next = newNode;
        rear = newNode;
        size++;
    }

    public E dequeue() {
        if (size == 0) throw new NoSuchElementException();

        E frontValue = (E) front.item;
        front = front.next;
        size--;

        return frontValue;
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
