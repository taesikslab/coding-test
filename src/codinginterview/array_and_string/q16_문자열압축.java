package codinginterview.array_and_string;

public class q16_문자열압축 {

    public static void main(String[] args) {
        System.out.println(compress("aabccccaaa"));
    }

    private static String compress(String s) {
        StringBuilder sb = new StringBuilder();

        char prev = s.charAt(0);
        int p1 = 0;
        int p2 = 0;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            p2++;

            if (cur != prev) {
                sb.append(prev).append(p2 - p1);
                p1 = p2;
                prev = cur;
            }
        }

        p2++;
        sb.append(prev).append(p2 - p1);

        return sb.toString();
    }
}
