package exercise.inflearnjava.stringandarray;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] anagrams) {
        Map<String, List<String>> map = new HashMap<>();

        for (String anagram : anagrams) {
            char[] chars = anagram.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(anagram);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }
}