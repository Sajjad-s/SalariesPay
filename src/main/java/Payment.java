import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

public class Payment {

    String status;
    String accountNumber;
    double amount;

    File file = new File("PaymentOrder.txt");

//    public Payment(String status, String accountNumber, double amount) {
//        this.status = status;
//        this.accountNumber = accountNumber;
//        this.amount = amount;
//        if (createPaymentFile()) {
//            writeInPaymentFile(status, accountNumber, amount);
//        }
//    }
//
//    public Payment() {
//        this.status = status;
//        this.accountNumber = accountNumber;
//        this.amount = amount;
//    }

    public boolean createPaymentFile() {
        try {
            if (file.createNewFile()) System.out.println("PaymentOrder.txt Created");
            else if (file.exists()) System.out.println("PaymentOrder.txt Exists");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in createPaymentFile");
            return false;
        }
    }

    public void writeInPaymentFile(String status, String accountNumber, double amount) {
        try {
            String inputOrder = status + "          " + accountNumber + "          " + Double.toString(amount) + "\n";
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(inputOrder);
            fileWriter.close();
            System.out.println("Write in PaymentOrder.txt complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void paymentToJson () throws FileNotFoundException {
       try {
           JSONObject jsonObject = new JSONObject();
           String[] lineToArray = null;
           String[] stringsArray = null;
           FileReader fileReader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String string = null;
           while ((string = bufferedReader.readLine()) != null ){
               lineToArray = string.split("         ");
               for(String word : lineToArray){
                   stringsArray = string.split("\\s");
                   if (word == "debtor"){
                       jsonObject.put(lineToArray[1], lineToArray[2]);
                   }
                   // Keep on nesting

               }
           }

       }catch (Exception e){
           e.printStackTrace();
           System.out.println("Error in PaymentToJason");
       }
}


    public void paymentRun() {
        if (createPaymentFile())
            writeInPaymentFile(status, accountNumber, amount);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String whitdrawNumber) {
        this.accountNumber = whitdrawNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}

