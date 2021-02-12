package inflearnjava.stringandarray;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("8F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("8-5g-3-J", 4));
    }

    public String licenseKeyFormatting(String S, int K) {
        String newStr = S.replace("-", "");
        newStr = newStr.toUpperCase();

        int length = newStr.length();
        StringBuilder sb = new StringBuilder(newStr);
        System.out.println(sb);

        for (int i = K; i < length; i += K) {
            sb.insert(length - i, '-');
        }

        return sb.toString();
    }
}