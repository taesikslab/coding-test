package codingtest.ch12;

import java.util.HashMap;
import java.util.Map;

public class q08 {

    public static void main(String[] args) {
        System.out.println(solve("K1KA5CB7"));
        System.out.println(solve("AJKDLSI412K4JSJ9D"));
    }

    private static String solve(String s) {
        Map<Character, String> map = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char) i, "");
        }

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                String cStr = map.get(c);
                cStr = "" + cStr + c;
                map.put(c, cStr);
            } else {
                sum += c - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String value : map.values()) {
            sb.append(value);
        }
        sb.append(sum);

        return sb.toString();
    }
}
