package datastructure.ch05_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void preorder(Node n) {
        if (n != null) {
            System.out.println(n.getValue());
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.println(n.getValue());
            inorder(n.getRight());
        }
    }

    public void postorder(Node n) {
        if (n != null) {
            preorder(n.getLeft());
            preorder(n.getRight());
            System.out.println(n.getValue());
        }
    }

    public void levelorder(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            Node m = queue.poll();
            System.out.println(m.getValue());

            if (m.getLeft() != null) {
                queue.offer(m.getLeft());
            }
            if (m.getRight() != null) {
                queue.offer(m.getRight());
            }
        }
    }

    public int size(Node n) {
        if (n == null) return 0;
        return 1 + size(n.getLeft()) + size(n.getRight());
    }

    public int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }

    public boolean isEqual(Node n, Node m) {
        if (n == null || m == null)
            return n == m;
        if (n.getValue() == m.getValue()) {
            return isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight());
        }
        return false;
    }

    public class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
