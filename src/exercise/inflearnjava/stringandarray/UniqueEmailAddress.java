package exercise.inflearnjava.stringandarray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        System.out.println(getUniqueEmailsNum(new String[]{
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"}));
    }

    private static int getUniqueEmailsNum(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            email = getUniqueEmail(email);
            emailSet.add(email);
            System.out.println(email);
        }

        return emailSet.size();
    }

    private static String getUniqueEmail(String email) {
        String[] names = email.split("@");
        String localName = names[0];
        String domainName = names[1];

        localName = localName.replace(".", "");

        int plusIndex;
        if (localName.contains("+")) {
            plusIndex = localName.indexOf("+");
            localName = localName.substring(0, plusIndex);
        }

        return localName + "@" + domainName;
    }
}
