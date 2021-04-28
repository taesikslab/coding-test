package exercise.programmers.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(solution(
        // new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
        // new int[]{2, 3, 4})));

        System.out.println(Arrays.toString(solution(
                new String[]{"XYZ", "XWY", "WXA"},
                new int[]{2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            int courseNum = course[i];
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                combination(order, new boolean[order.length()], 0, order.length(), courseNum, map);
            }

            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entries);
            List<Map.Entry<String, Integer>> sorted = entryList.stream()
                    .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .collect(Collectors.toList());

            if (!sorted.isEmpty()) {
                Map.Entry<String, Integer> maxEntry = sorted.get(0);
                Integer max = maxEntry.getValue();
                if (max >= 2) {
                    answerList.add(maxEntry.getKey());
                }

                for (int j = 1; j < sorted.size(); j++) {
                    Map.Entry<String, Integer> entry = sorted.get(j);
                    if (entry.getValue().equals(max)) {
                        answerList.add(entry.getKey());
                    } else {
                        break;
                    }
                }
            }

        }

        return answerList.stream()
                .sorted()
                .toArray(String[]::new);
    }

    public static void combination(String order, boolean[] visited, int start, int n, int r, Map<String, Integer> map) {
        if (r == 0) {
            StringBuilder menuCombination = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    menuCombination.append(order.charAt(i));
                }
            }
            String key = menuCombination.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(order, visited, i + 1, n, r - 1, map);
            visited[i] = false;
        }
    }
}
