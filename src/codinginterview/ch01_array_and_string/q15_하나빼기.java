package codinginterview.ch01_array_and_string;

public class q15_하나빼기 {

    public static void main(String[] args) {
        System.out.println(updateOneChar("pale", "ple"));
        System.out.println(updateOneChar("pales", "pale"));
        System.out.println(updateOneChar("pale", "bale"));
        System.out.println(updateOneChar("pale", "bake"));
    }

    private static boolean updateOneChar(String source, String target) {
        int sLength = source.length();
        int tLength = target.length();
        if (sLength == tLength) {
            var count = 0;
            for (int i = 0; i < sLength; i++) {
                if (source.charAt(i) == target.charAt(i)) continue;
                count++;
            }
            return count == 1;
        } else if (Math.abs(sLength - tLength) == 1) {
            String newSource = sLength > tLength ? source : target;
            String newTarget = sLength > tLength ? target : source;
            var count = 0;
            var p = 0;
            for (var i = 0; i < newSource.length(); i++) {
                if (i == newSource.length() - 1) {
                    return true;
                }
                if (newSource.charAt(i) == newTarget.charAt(p)) {
                    p++;
                    continue;
                }
                count++;
                if (count >= 2) return false;
            }
            return count == 1;
        }

        return false;
    }
}
