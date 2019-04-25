import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static int numUniqueEmailsNaive(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();
        for(String email : emails) {
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];
            localName = localName.replaceAll("\\+", " +").split(" +")[0];
            localName = localName.replace(".", "");
            String fwdEmail = localName + '@' + domainName;
            emailSet.add(fwdEmail);
        }
        return emailSet.size();
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];
            for (int i=0 ; i<localName.length() ; i++) {
                char c = localName.charAt(i);
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    stringBuilder.append(c);
                }
            }
            emailSet.add(stringBuilder.append('@').append(domainName).toString());
        }
        return emailSet.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String[] emails2 = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        String[] emails3 = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(numUniqueEmailsNaive(emails));
        System.out.println(numUniqueEmailsNaive(emails2));
        System.out.println(numUniqueEmailsNaive(emails3));
        System.out.println(numUniqueEmails(emails));
        System.out.println(numUniqueEmails(emails2));
        System.out.println(numUniqueEmails(emails3));
    }
}