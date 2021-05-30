import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Balance {

    String depositNumber;
    double amount;
    File file = new File("Balances.txt");

//    public Balance(String depositNumber, double amount) {
//        this.depositNumber = depositNumber;
//        this.amount = amount;
//        if (createBalanceFile()) {
//            writeInBalanceFile(depositNumber, amount);
//        }
//    }

//    public Balance(String depositNumber) {
//        searchInBalance(depositNumber);
//    }

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
    public Boolean editBalanceFile(String depositNumber, double amount){
        FileWriter fileWriter = new 
        return true
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
        String[] lineToArray = null;
        String[] stringsArray = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                lineToArray = string.split("          ");
                for (String word : lineToArray) {
                    stringsArray = string.split("\\s+");
                    if (stringsArray[0].equals(depositNumber)) {
                        return Double.parseDouble(stringsArray[1]);
                    }

                }
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in searchInBalance");
            return -1;
        }
        return -1;
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


