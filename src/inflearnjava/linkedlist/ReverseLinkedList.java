package inflearnjava.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        System.out.println(solve(l1));
        System.out.println(reverseList(l1));
    }

    public static ListNode reverseList(ListNode current) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.val - o1.val;
            }
        });
        ListNode node = current;
        while (node != null) {
            pq.offer(node);
            node = node.next;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p.next.next = null;
            p = p.next;
        }

        return newHead.next;
    }

    public static ListNode solve(ListNode current) {
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            if (next == null) return String.valueOf(val);
            return val + " -> " + next.toString();
        }
    }
}