package exercise.inflearnjava.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        System.out.println(reverseIteratively(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        System.out.println(reverseRecursively(l2));
    }

    public static ListNode reverseIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    private static ListNode reverseRecursively(ListNode head) {
       if (head == null || head.next == null)
           return head;

       ListNode p = reverseRecursively(head.next);
       head.next.next = head;
       head.next = null;
       return p;
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
