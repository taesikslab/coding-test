package datastructure.ch06_SearchTree;

public class BinarySearchTree {

    /*
    이진 탐색 트리 특징
    - 기준 노드 N에서 왼쪽의 서브 트리 노드의 값은 N보다 작아야 하며 오른쪽 서브 트리의 값은 N보다 커야 합니다.
    - 노드는 중복된 값을 가질 수 없습니다.
    - 자식이 2개 이하여야 합니다.
    */

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node searchRecursive(Node node, int value) {
        if (node == null) return null;

        int compare = node.value;
        if (value == compare) return node;
        else if (value > compare) return searchRecursive(node.right, value);
        else return searchRecursive(node.left, value);
    }

    public Node search(int value) {
        if (root == null) return null;

        Node target = root;
        while (target != null && target.value != value) {
            if (target.value > value) {
                target = target.left;
            } else {
                target = target.right;
            }
        }
        return target;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value, null, null);
        }

        Node target = root;
        Node parent = null;
        while (target != null) {
            parent = target;

            // 현재 노드와 중복되는 값을 가지는지 검사
            if (target.getValue() == value) {
                System.out.printf("%s는(은) 중복된 값입니다. 삽입을 중단합니다.%n", value);
                break;
            }

            if (target.getValue() > value) {
                target = target.getLeft();
                if (target == null) {
                    parent.setLeft(new Node(value, null, null));
                }
            } else {
                target = target.getRight();
                if (target == null) {
                    parent.setRight(new Node(value, null, null));
                }
            }
        }
    }

    public Node delete(Node node, int value) {
        if (node == null) return null;

        if (root.getValue() == value) {
            if (root.getLeft() == null && root.getRight() == null) {
                // 자식 노드가 모두 없는 경우
                root = null;
                return null;
            } else if (root.getLeft() != null && root.getRight() == null) {
                // 왼쪽 자식 노드만 존재하는 경우
                Node left = root.getLeft();
                root = null;
                return left;
            } else if (root.getLeft() == null && root.getRight() != null) {
                // 오른쪽 자식 노드만 존재하는 경우
                Node right = root.getRight();
                root = null;
                return right;
            } else { // 자식 노드가 2개인 경우
                Node children = getMin(root.getRight());
                root.setValue(children.getValue());
                root.setRight(delete(root.getRight(), children.getValue())); // 오른쪽 서브트리로 이동해서 값을 교환한 노드를 제거
            }
        }

        if (root.getValue() > value) {
            root.setLeft(delete(root.getLeft(), value));
        } else {
            root.setRight(delete(root.getRight(), value));
        }
        return root;
    }

    private Node getMin(Node node) {
        if (node == null) return null;

        if (node.left == null) {
            return node;
        }
        return getMin(node.getLeft());
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
