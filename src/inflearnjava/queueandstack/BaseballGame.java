package inflearnjava.queueandstack;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(strs));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (String op : ops) {
            switch (op) {
                case "+":
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first);
                    stack.push(second);
                    stack.push(first + second);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                default:
                    int sum = Integer.parseInt(op);
                    stack.push(sum);
                    break;
            }
        }

        System.out.println(stack.toString());
        while (!stack.isEmpty()) result += stack.pop();

        return result;
    }
}
