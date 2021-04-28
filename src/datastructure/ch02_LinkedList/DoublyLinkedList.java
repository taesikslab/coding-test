package datastructure.ch02_LinkedList;

public class DoublyLinkedList<T> {

    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value, null, null);
            return;
        }

        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }

        Node newNode = new Node(value, pointer.next, null);
        pointer.next = newNode;
    }

    public void delete(T value) {
        Node pointer = this.head;
        if (pointer.value == value) {
            Node removeNode = this.head;
            this.head = this.head.next;
            removeNode = null;
            return;
        }

        Node prevNode = pointer;
        while (pointer != null && pointer.value != value) {
            prevNode = pointer;
            pointer = pointer.next;
        }

        Node temp = pointer.next;
        if (temp == null) {
            prevNode.next = null;
        } else {
            temp.prev = prevNode;
            prevNode.next = temp;
        }
        pointer = null;
    }

    public class Node<T> {

        private T value;
        private Node prev;
        private Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
