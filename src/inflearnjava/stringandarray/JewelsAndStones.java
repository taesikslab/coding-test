package inflearnjava.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(solve("aA", "aAAbbbb"));
    }

    public static int solve(String jewels, String stone) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }

        int count = 0;
        for (char stoneChar : stone.toCharArray()) {
            if(set.contains(stoneChar)) count++;
        }

        return count;
    }
}
