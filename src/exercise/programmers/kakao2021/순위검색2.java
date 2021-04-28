package exercise.programmers.kakao2021;

import java.util.*;

public class 순위검색2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        )));
    }

    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infoMap = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(s[0]);
            sb.append(s[1]);
            sb.append(s[2]);
            sb.append(s[3]);
            String key = sb.toString();
            List<Integer> scores;
            if (infoMap.containsKey(key)) {
                scores = infoMap.get(key);
            } else {
                scores = new ArrayList<>();
            }
            scores.add(Integer.parseInt(s[4]));
            infoMap.put(key, scores);
        }

        infoMap.forEach((key, value) -> Collections.sort(value));

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] s = query[i].split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(s[0]);
            sb.append(s[2]);
            sb.append(s[4]);
            sb.append(s[6]);
            String key = sb.toString();
            int score = Integer.parseInt(s[7]);

            if (infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                int arr[] = scores.stream().mapToInt(k -> k).toArray();
                int index = lowerBoundSearch(arr, 0, arr.length - 1, score);
                result[i] = arr.length - index - 1;
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static int lowerBoundSearch(int[] arr, int s, int e, int k) {
        if (s >= e) {
            return s + 1;
        }
        int m = (s + e) / 2;
        if (arr[m] < k) {
            return lowerBoundSearch(arr, m + 1, e, k);
        } else { // arr[m] > k
            return lowerBoundSearch(arr, s, m, k);
        }
    }
}
