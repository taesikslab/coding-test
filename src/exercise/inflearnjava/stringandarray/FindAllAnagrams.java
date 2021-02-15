package exercise.inflearnjava.stringandarray;

import java.util.*;

public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("caacbabacad", "aac"));
    }

    public static List<Integer> findAnagrams(String s, String pat) {
        Map<Character, Integer> pattern = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            char key = pat.charAt(i);
            pattern.put(key, pattern.getOrDefault(key, 0) + 1);
        }
        System.out.println(pattern.toString());

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length() - pat.length() + 1; i++) {
            Map<Character, Integer> anagram = new HashMap<>();
            for (int j = 0; j < pat.length(); j++) {
                char key = s.charAt(i + j);
                anagram.put(key, anagram.getOrDefault(key, 0) + 1);
            }

            if(pattern.equals(anagram)) {
                answer.add(i);
            }
        }

        return answer;
    }
}
