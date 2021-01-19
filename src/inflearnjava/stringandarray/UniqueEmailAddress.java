package inflearnjava.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
        System.out.println(uniqueEmailAddress.numUniqueEmails(new String[]{
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"}));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            int i1 = email.indexOf('@');
            int i2 = email.indexOf('+');

            String localName = email.substring(0, i2);
            localName = localName.replace(".", "");
            System.out.println(localName);

            String newEmail = localName.concat(email.substring(i1));
            emailSet.add(newEmail);
            System.out.println(newEmail);
        }

        return emailSet.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> seen = new HashSet();

        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            // Note: one should escape the specific character '.',
            // since it is treated as a regex expression.
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }

    // =================== 다른 풀이 ===================
    public static int numUniqueEmails3(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String localName = getLocalName(email);
            String domainName = getDomainName(email);
            uniqueEmails.add(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }

    private static String getDomainName(String email) {
        return email.substring(email.indexOf('@')+1);
    }

    private static String getLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+') {
                break;
            }
            if (email.charAt(i) == '@') {
                break;
            }
            String str = String.valueOf(email.charAt(i));
            sb.append(str);

        }
        return sb.toString();
    }


    public static int numUniqueEmails_split(String[] emails) {
        Set<String> sentEmails = new HashSet();
        if(emails == null) {
            return 0;
        }

        for(String email : emails) {
            String[] parts = email.split("\\@");
            String[] partsForPlus = parts[0].split("\\+");
            String[] partsForDot = partsForPlus[0].split("\\.");
            StringBuilder emailM = new StringBuilder();
            for(String part : partsForDot) {
                emailM.append(part);
            }
            emailM.append("@"+parts[1]);
            sentEmails.add(emailM.toString());
        }
        return sentEmails.size();
    }
}
