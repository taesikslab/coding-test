package inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMapping {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
        System.out.println(Arrays.toString(anagramMappings(new int[]{12, 28, 46, 32, 12}, new int[]{12, 12, 32, 46, 28})));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }

        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            answer[i] = map.get(A[i]);
        }

        return answer;
    }
}
