package exercise.datastructure_with_java;

public class LinkedListExercise<E> {

    private Node<E> head;
    private int size;

    public LinkedListExercise() {
        this.head = null;
        this.size = 0;
    }

    public int search(E target) {
        if (head == null) return -1;

        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            if (p.getItem() == target) return i;
            p = p.getNext();
        }

        return -1;
    }

    public void insertFront() {

    }


    static class Node<E> {

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
