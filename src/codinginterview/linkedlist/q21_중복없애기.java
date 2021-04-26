package codinginterview.linkedlist;

import java.util.HashSet;

public class q21_중복없애기 {

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups1(head);
        System.out.println(head.printForward());
    }

    public static void deleteDups1(LinkedListNode n) {
        HashSet set = new HashSet();
        LinkedListNode prev = null;
        while (n != null){
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public static void deleteDups2(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
