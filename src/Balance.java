import java.io.File;
import java.io.FileWriter;

public class Balance {

    String depositNumber;
    double amount;

    File file = new File("Balances.txt");

    public boolean createBalanceFile() {
        try {
            if (file.createNewFile()) System.out.println("Balances.txt Created");
            else if (file.exists()) System.out.println("Balances.txt Exists");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in createBalanceFile");
            return false;
        }
    }

    public Boolean writeInBalanceFile(String depositNumber, double amount) {
        String inputBalance;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            inputBalance = depositNumber + "        " + Double.toString(amount) + "\n";
            fileWriter.write(inputBalance);
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in writeInBalanceFile");
            return false;
        }
    }

    public void balanceRun(){
        if(createBalanceFile()) writeInBalanceFile(depositNumber, amount);
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
