package exercise.inflearnjava.stringandarray;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("8F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("8-5g-3-J", 4));
    }

    private static String licenseKeyFormatting(String s, int k) {
        String newString = s.replace("-", "");
        newString = newString.toUpperCase();

        StringBuilder sb = new StringBuilder(newString);
        int length = newString.length();
        for (int i = k; i < length; i += k) {
            sb.insert(length - i, '-');
        }

        return sb.toString();
    }
}
