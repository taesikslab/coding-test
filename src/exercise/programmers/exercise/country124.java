package exercise.programmers.exercise;

public class country124 {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}
