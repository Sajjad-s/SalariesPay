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

//    public double searchInBalance(String depositNumber) {
//        try {
//            String[] words = null;
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String string;
//            String inputBalanceToFind = depositNumber;
//            while ((string = bufferedReader.readLine()) != null) {
//                words = string.split("        ");
//
//                for (int i = 1; i < words.length; i += 2) {
//                    if (words[i].equals(inputBalanceToFind)) {
//                        System.out.println(words[i] + " - " + words[i - 1]);
//                    }
//                    else
//                        System.out.println("Not Found");
//                }
//            }
//            fileReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error in searchInBalance");
//        }
//        return 1;
//    }

    public double searchInBalance(String depositNumber) {
        try {
            String[] lineToArray = null;
            String[] stringsArray = null;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                lineToArray = string.split("        ");
                for (String word : lineToArray) {
                    if (word.equals(depositNumber)) {
                        stringsArray = string.split("\\s+");
                        return Double.parseDouble(stringsArray[1]);
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


