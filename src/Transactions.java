import java.io.File;
import java.io.FileWriter;

public class Transactions {
    String depositAccountNumber;
    String withdrawalAccountNumber;
    double amount;
    File file = new File("Transactions.txt");

    public boolean createTransactionsFile() {
        try {
            if (file.createNewFile()) System.out.println("Transactions.txt Created");
            else if (file.exists()) System.out.println("Transactions.txt Already Exists");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Happened in createTransactionsFile");
            return false;
        }
    }

    public void writeInTransactionsFile(String depositAccountNumber, String withdrawalAccountNumber, double amount) {
        String completeTransaction = withdrawalAccountNumber + "        " + depositAccountNumber + "        " +Double.toString(amount) + "\n";
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(completeTransaction);
            fileWriter.close();
            System.out.println("Write in Transactions.txt complete");
        }catch (Exception e){
            System.out.println("Error in writeInTransactionsFile");
        }
    }

    public void transactionRun(){
        if(createTransactionsFile())
            writeInTransactionsFile(depositAccountNumber, withdrawalAccountNumber, amount);

    }

    public String getDepositAccountNumber() {
        return depositAccountNumber;
    }

    public void setDepositAccountNumber(String depositAccountNumber) {
        this.depositAccountNumber = depositAccountNumber;
    }

    public String getWithdrawalAccountNumber() {
        return withdrawalAccountNumber;
    }

    public void setWithdrawalAccountNumber(String withdrawalAccountNumber) {
        this.withdrawalAccountNumber = withdrawalAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
