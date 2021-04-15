package exercise.programmers.monthly.monthly202104;

import java.util.Stack;

public class q2 {

    public static void main(String[] args) {
        //System.out.println(solution("[](){}")); // 3
        //System.out.println(solution("}]()[{")); // 2
        System.out.println(solution("{{}}"));
    }

    public static int solution(String s) {
        if (s.length() % 2 == 1) {
            return 0;
        }

        String[] rotated = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i));
            sb.append(s.substring(0, i));
            rotated[i] = sb.toString();
        }

        int answer = 0;
        for (int i = 0; i < rotated.length; i++) {
            String r = rotated[i];
            if (validate(r)) answer++;
        }

        return answer;
    }

    private static boolean validate(String r) {
        Stack<Character> stack = new Stack<>();
        char[] chars = r.toCharArray();
        char c = chars[0];
        if (c == '{' || c == '[' || c == '(') {
            stack.push(c);
        } else {
            return false;
        }

        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            Character peek = stack.peek();
            char cur = chars[i];
            if (peek == '{' && cur == '}' ||
                    peek == '[' && cur == ']' ||
                    peek == '(' && cur == ')') {
                stack.pop();
                continue;
            }
            if (peek == '{' && (cur == ']' || cur == ')') ||
                    peek == '[' && (cur == '}' || cur == ')') ||
                    peek == '(' && (cur == ']' || cur == '}')) {
                return false;
            }
            stack.push(cur);
        }

        return stack.isEmpty();
    }
}
