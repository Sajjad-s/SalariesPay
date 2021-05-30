import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Core {
    public static void main(String[] args) throws Exception {

        Payment payment = new Payment();
        Balance balance = new Balance();
        JSONObject jsonObject = (JSONObject) payment.paymentToJson();
        String withDrawAccountNumber = String.valueOf(jsonObject.get("withDrawAccountNumber"));
        double amount = Integer.parseInt(String.valueOf(jsonObject.get("Amount")));
        System.out.println("Result: " + withDrawAccountNumber + "\n" + "Amount: " + amount);
        double accountBalance = balance.searchInBalance(withDrawAccountNumber);
        if (accountBalance != -1) {
            if (amount <= accountBalance) {
                System.out.println("Valid");

            }
            else {
                System.out.println("Not Valid");
            }
        }
    }
}
