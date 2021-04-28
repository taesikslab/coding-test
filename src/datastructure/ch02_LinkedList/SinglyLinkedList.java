package datastructure.ch02_LinkedList;

public class SinglyLinkedList<T> {

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }

        Node pointer = head;
        while (head.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(value, null);
    }

    public void delete(T value) {
        Node pointer = head;

        if (pointer.getItem() == value) {
            Node removeNode = head;
            head = head.next;

            removeNode = null;
            return;
        }

        Node temp = pointer;
        while (pointer != null && pointer.item != value) {
            temp = pointer;
            pointer = pointer.next;
        }

        // 마지막 노드를 삭제하는 경우
        if (pointer.next == null) {
            temp.next = null;
        } else {
            temp.next = pointer.next;
        }
        pointer = null;
    }

    public static class Node<T> {

        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }
    }
}
