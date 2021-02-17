package exercise.inflearnjava.queueandstack;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(strs));
    }

    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];

            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    Integer top = stack.peek();
                    stack.push(top * 2);
                    break;
                case "+":
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second);
                    stack.push(first);
                    stack.push(first + second);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
