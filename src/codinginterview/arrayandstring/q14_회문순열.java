package codinginterview.arrayandstring;

public class q14_회문순열 {

    public static void main(String[] args) {
        System.out.println(solve("taco cat"));
        System.out.println(solve(""));
        System.out.println(solve("a"));
        System.out.println(solve("atco cta"));
    }

    public static boolean solve(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[128];

        s = s.replace(" ", "");

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 32) continue;
            count[chars[i]]++;
        }

        int oddCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
            }
        }

        if (s.length() % 2 == 0) {
            return oddCount == 0;
        } else {
            return oddCount == 1;
        }
    }
}
