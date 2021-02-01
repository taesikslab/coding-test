package inflearnjava.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);

        System.out.println(solve_recursive(root));
        System.out.println(solve_dfs(root));
        System.out.println(solve_bfs(root));
    }

    public static int solve_recursive(TreeNode root) {
        if (root == null) return 0;

        int leftMax = solve_recursive(root.left);
        int rightMax = solve_recursive(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }

    public static int solve_dfs(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = Math.max(max, count);

            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(count + 1);
                System.out.println(Arrays.toString(stack.toArray()));
            }
            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(count + 1);
                System.out.println(Arrays.toString(stack.toArray()));
            }
        }

        return max;
    }

    public static int solve_bfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            count++;
        }

        return count;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
