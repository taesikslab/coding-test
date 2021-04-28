package exercise.programmers.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순위검색 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        )));
    }

    public static int[] solution(String[] info, String[] query) {

        List<Developer> developers = new ArrayList<>();
        for (String i : info) {
            String[] s = i.split(" ");
            developers.add(new Developer(s[0], s[1], s[2], s[3], Integer.parseInt(s[4])));
        }

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] s = query[i].split(" ");
            int n = 0;
            for (Developer developer : developers) {
                if (developer.isEligible(s[0], s[2], s[4], s[6], Integer.parseInt(s[7]))) {
                    n++;
                }
            }
            result[i] = n;
        }

        return result;
    }

    public static class Developer {

        String pl;
        String type;
        String career;
        String food;
        int score;

        public Developer(String pl, String type, String career, String food, int score) {
            this.pl = pl;
            this.type = type;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        public boolean isEligible(String pl, String type, String career, String food, int score) {
            if (isEligible(pl, this.pl) && isEligible(type, this.type)
            && isEligible(career, this.career) && isEligible(food, this.food)
            && (this.score >= score)) {
                return true;
            } else {
                return false;
            }
        }

        private boolean isEligible(String val, String target) {
            if (val.equals("-")) {
                return true;
            } else if (val.equals(target)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
