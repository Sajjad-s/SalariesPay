import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Payment {

    String status;
    String accountNumber;
    double amount;

    File file = new File("PaymentOrder.txt");

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

    public void paymentRun() {
        if(createPaymentFile())
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

