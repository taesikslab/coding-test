package exercise.inflearnjava.stringandarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("bcbca"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabbaaabbbbbaa"));
    }

    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1)
                counter++;
            end++;

            while (counter > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0)
                    counter--;
                start++;
            }

            length = Math.max(length, end - start);
        }


        return length;
    }
}
