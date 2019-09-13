import java.util.*;

public class Test3 {

    public static int calculate_total_owed(List<String> actions) {
        // Write your code here
        // invoice : id=14&amount=800&currency=USD
        // action: CREATE: id=14&amount=800&currency=USD
        // for each action, update a map
        // keep 2 maps, first for create/finalized invoices with amount currency pair
        // invoices cannot be paid without finalized, cannot be finalized without being paid
        // second with paid invoices
        // invoice_id: String[3]
        int total_owed = 0;
        Map<String, String[]> unpaidInvoicesMap = new HashMap<>();
        Set<String> paidInvoices = new HashSet<>();

        for (String action : actions) {
            String[] components = parseAction(action);
            String invoiceId = components[0];
            String amount = components[1];
            String currency = components[2];
            int spaceIdx = action.indexOf(" ");
            String actionType = action.substring(0, spaceIdx - 1);
            if (actionType.equals("PAY")) {
                // either create or finalize
                boolean isValid = checkInvoiceEntry(unpaidInvoicesMap, invoiceId);
                if (isValid) {
                    // String[] details = unpaidInvoicesMap.get(invoiceId);
                    // String invoiceAmount = details[1];
                    // String invoiceCurrency = details[2];
                    // if (invoiceCurrency.equals("USD"))
                    //     total_owed -= Integer.parseInt(invoiceAmount);
                    unpaidInvoicesMap.remove(invoiceId);
                    paidInvoices.add(invoiceId);
                }
            } else {
                String[] details = {actionType, amount, currency};
                unpaidInvoicesMap.put(invoiceId, details);
            }
        }

        for (String[] details : unpaidInvoicesMap.values()) {
            String invoiceStatus = details[0];
            int amount = Integer.parseInt(details[1]);
            String currency = details[2];
            if (currency.equals("USD")) {
                total_owed += amount;
            }
        }
        return total_owed;
    }

    private static boolean checkInvoiceEntry(Map<String, String[]> unpaidInvoiceMap, String invoiceId) {
        if (unpaidInvoiceMap.containsKey(invoiceId)) {
            String[] details = unpaidInvoiceMap.get(invoiceId);
            return details[0].equals("FINALIZE");
        }
        return false;
    }

    private static String[] parseAction(String action) {
        String[] parsedValues = new String[3];
        if (!action.isEmpty()) {
            String[] components = action.split("&");
            String invoiceId = components[0].split("=")[1];
            if (components.length == 3) {
                String amount = components[1].split("=")[1];
                String currency = components[2].split("=")[1];
                parsedValues[1] = amount;
                parsedValues[2] = currency;
            }
            parsedValues[0] = invoiceId;
        }
        return parsedValues;
    }

    public static void main(String[] args) {
        List<String> actions = new ArrayList<>();
        actions.add("CREATE: id=14&amount=800&currency=USD");
        actions.add("FINALIZE: id=14&amount=800&currency=USD");
        actions.add("PAY: id=14");
        System.out.println(calculate_total_owed(actions));
    }
}
