package exercise.inflearnjava.queueandstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty())
                    return false;
                Character top = stack.pop();
                if (!top.equals(map.get(c)))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
