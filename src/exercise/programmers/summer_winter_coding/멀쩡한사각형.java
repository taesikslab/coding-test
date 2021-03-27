package exercise.programmers.summer_winter_coding;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long answer = 0;
        for (double i = 1; i <= w; i++) {
            double cur = i * (double) h / (double) w;
            cur = Math.ceil(cur);
            answer += h - cur;
        }

        return answer * 2;
    }
}
