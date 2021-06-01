import java.io.*;

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

    static boolean editBalanceFile(String accountNumber, double oldAmount, double newAmount) {

        String existAccountDetail = accountNumber + "          " + String.valueOf(oldAmount);
//        String existAccountDetail ="2.20.200.2          500.0";
        String newAccountDetail =   accountNumber + "          " + String.valueOf(newAmount);
//        String newAccountDetail =  "2.20.200.2          1100.0";

        File fileToBeModified = new File("Balances.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(existAccountDetail, newAccountDetail);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
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
            String string = null;
            while ((string = bufferedReader.readLine()) != null) {
                lineToArray = string.split("        ");
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


