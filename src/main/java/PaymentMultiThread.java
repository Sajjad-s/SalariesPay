import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentMultiThread implements Runnable {

    Debtor debtor;
    List<Creditors> creditorsList = new ArrayList<>();
    File file = new File("PaymentOrder.txt");

    public PaymentMultiThread() {
        run();
    }

    @Override
    public void run() {
        System.out.println("Thread id : " + Thread.currentThread().getId());
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] lineToArray = null;
            String[] stringsArray = null;
            double amountOfPayment = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lineToArray = line.split("          ");
                for (String word : lineToArray) {
                    stringsArray = line.split("\\s");

                    if (word.equals("debtor")) {
                        debtor = new Debtor(lineToArray[1], lineToArray[2]);
                        System.out.println("lineToArray[1] in debtor :  " + lineToArray[1] + "  lineToArray[2] in debtor :  " + lineToArray[2]);
                    }

                    if (word.equals("creditor")) {
                        creditorsList.add(new Creditors(lineToArray[1], lineToArray[2]));
                        System.out.println("lineToArray[1] in creditor :  " + lineToArray[1] + "  lineToArray[2] in creditor :  " + lineToArray[2]);
                    }
                }
            }
            System.out.println("Debtor " + getDebtor().getDepositAccountNumber() + " " + getDebtor().getDepositAmount());
            for (int i = 0; i <creditorsList.size() ; i++) {
                System.out.println("creditor " + i + " is: " + creditorsList.get(i).getCreditorAccountNumber() + " " + creditorsList.get(i).getWithDrawAmount());

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in PaymentToJason");
        }

    }
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

    public List<Creditors> getCreditorList() {
        return creditorsList;
    }

    public Debtor getDebtor() {
        return debtor;
    }
}
