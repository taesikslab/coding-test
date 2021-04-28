package datastructure.ch02_LinkedList;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int value) {
        if (this.head == null && this.tail == null) {
            Node node = new Node(value);
            this.head = node;
            this.tail = node;
            return;
        }

        Node pointer = this.tail;
        // 마지막 위치에 새 노드 삽입
        pointer.next = new Node(value);

        // tail은 새로 삽입한 노드를 재할당
        this.tail = pointer.next;
        // tail의 next 포인터를 head로 연결하여 원형 연결 리스트 조건 만족시킴
        this.tail.next = head;
    }

    public void delete(int value) {
        Node pointer = this.head;

        if (pointer.getValue() == value) {
            Node removeNode = this.head;
            this.head = this.head.next;
            removeNode = null;
            return;
        }

        // 포인터가 tail이 아니며 값이 다를 때까지 반복
        Node temp = null;
        while (pointer.next != this.tail && pointer.getValue() != value) {
            temp = pointer;
            pointer = pointer.next;
        }

        // 삭제할 노드가 tail일 경우 앞 노드를 tail로 재할당하고 next를 head로 연결
        if (pointer.next.getValue() == value) {
            this.tail = pointer;
            this.tail.next = this.head;
        } else {
            temp.next = pointer.next;
        }
        pointer = null;
    }

    class Node {
        private int value; // 값
        private Node next; // 다음 포인터

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return this.value;
        }
    }
}
