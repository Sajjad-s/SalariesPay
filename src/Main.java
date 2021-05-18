import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        Payment payment = new Payment();
//        payment.setStatus("creditor");
//        payment.setAccountNumber("1.20.100.2");
//        payment.setAmount(700);
//        payment.paymentRun();

        Balance balance = new Balance("1.10.100.2");
//        balance.setDepositNumber("1.10.100.2");
//        balance.setAmount(2000);
//        balance.balanceRun();

//        Transactions transactions = new Transactions();
//        transactions.setAmount(500);
//        transactions.setDepositAccountNumber("1.10.100.4");
//        transactions.setWithdrawalAccountNumber("1.20.100.5");
//        transactions.transactionRun();

        Transactions transactions = new Transactions("1.10.500.4","1.10.600.5",800.0);
        Payment payment = new Payment("debtor", "1.10.500.4", 1000);
//        Balance balance = new Balance("1.10.500.4", 1000);
    }



    private static int checkOrCreateFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return 1;
            } else {
                System.out.println("File already exists.");
                return 1;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 0;
        }
    }

    private static void writeFile() {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
