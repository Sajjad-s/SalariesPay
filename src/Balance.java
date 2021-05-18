import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Balance {

    String depositNumber;
    double amount;
    File file = new File("Balances.txt");

    public Balance(String depositNumber, double amount) {
        this.depositNumber = depositNumber;
        this.amount = amount;
        if (createBalanceFile()) {
            writeInBalanceFile(depositNumber, amount);
        }
    }

    public Balance(String depositNumber) {
        searchInBalance(depositNumber);
    }

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

    public double searchInBalance(String depositNumber) {
        try {
            String[] words = null;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            String inputBalanceToFind = depositNumber;
            while ((string = bufferedReader.readLine()) != null) {
                words = string.split("        ");
                for (String word : words) {
                    if (word.equals(inputBalanceToFind)) {
                        System.out.println("string :" + string);
                    }
                }
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in searchInBalance");
        }
        return 1;
    }

    public void balanceRun() {
        if (createBalanceFile()) writeInBalanceFile(depositNumber, amount);
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
