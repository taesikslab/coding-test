package exercise.programmers.kakao2020;

public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = 0;

        int start = 0;
        int end = 0;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String cur;
            String prev = "";
            for (int j = 0; j < s.length(); j += i) {


                cur = s.substring(j, j + i);
                if (cur.equals(prev)) {
                    end = i + j;
                    prev = cur;
                } else {
                    if (j == 0) {
                        prev = cur;
                        continue;
                    }

                    int length = (end - start) / i;
                    if (length != 0) {
                        sb.append(length);
                    }
                    sb.append(prev);

                    end = j;
                    start = end;
                    prev = cur;
                }
            }

            answer = Math.max(sb.length(), answer);
            System.out.println(sb.toString());
        }

        return answer;
    }
}
