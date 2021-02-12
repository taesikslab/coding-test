package exercise.inflearnjava.stringandarray;

public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(solve("aA", "aAAbbbb"));
    }

    private static int solve(String jewels, String stones) {
        int answer = 0;
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            if (jewels.contains(String.valueOf(stone))) {
                answer++;
            }
        }

        return answer;
    }
}
