package inflearnjava.stringandarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        LongestSubMostTwoDist q = new LongestSubMostTwoDist();
        System.out.println(q.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(q.lengthOfLongestSubstringTwoDistinct("aabbaaabbbbbaa"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // data structure
        int start = 0, end = 0, length = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        // iteration
        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) counter--;
                start++;
            }

            length = Math.max(length, end - start);
        }

        return length;
    }
}
