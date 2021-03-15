package exercise.programmers.summer_winter_coding;

import java.util.LinkedList;
import java.util.Queue;

public class skill_tree {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();

        for (String skill_tree : skill_trees) {
            queue.clear();
            for (int i = 0; i < skill.length(); i++) {
                queue.offer(skill.toCharArray()[i]);
            }
            answer++;
            for (char c : skill_tree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    Character s = queue.peek();
                    if (s == c) {
                        queue.poll();
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
