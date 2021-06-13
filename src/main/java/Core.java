import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core {
    public static void main(String[] args) throws Exception {

        Balance balance = new Balance();
        Transactions transactions ;

        PaymentMultiThread paymentMultiThread = new PaymentMultiThread();
        List<Creditors> creditorsList = paymentMultiThread.getCreditorList();
        ExecutorService  executorService = Executors.newFixedThreadPool(5);
        executorService.execute(paymentMultiThread);
        Debtor debtor = paymentMultiThread.getDebtor();
        for (int i = 0; i <creditorsList.size() ; i++) {
            System.out.println("***" + creditorsList.get(i).getWithDrawAmount()+"***"+creditorsList.get(i).getCreditorAccountNumber());
        }
        System.out.println("***" + debtor.getDepositAccountNumber() + "***" + debtor.getDepositAmount());

        System.out.println("debtor Account number is: (depositAccountNumber) : " + debtor.depositAccountNumber );
        System.out.println("debtor withdraw Amount is: (depositAmount)       : " + debtor.depositAmount );
        System.out.println("Balance of debtor is: " + balance.searchInBalance(debtor.depositAccountNumber));



        if(balance.searchInBalance(debtor.depositAccountNumber) >= Double.parseDouble(debtor.depositAmount) ){
            System.out.println("Transaction Possible");
            for (Creditors creditor : creditorsList ) {
                System.out.println("Transfer to: " + creditor.getCreditorAccountNumber() + " Amount to deposit is: " + creditor.getWithDrawAmount());
                double newDebotorsAmount = Double.parseDouble(creditor.getWithDrawAmount()) +  balance.searchInBalance(creditor.creditorAccountNumber);
                if(balance.editBalanceFile(creditor.getCreditorAccountNumber(),balance.searchInBalance(creditor.creditorAccountNumber), newDebotorsAmount)) {
                    System.out.println("New Balance of " +creditor.creditorAccountNumber + " is: " + balance.searchInBalance(creditor.creditorAccountNumber));
                    transactions = new Transactions(creditor.creditorAccountNumber, debtor.depositAccountNumber,  Double.parseDouble(creditor.withDrawAmount));
                }
            }
            if(balance.editBalanceFile(paymentMultiThread.getDebtor().getDepositAccountNumber(),
                    balance.searchInBalance(debtor.getDepositAccountNumber()) ,
                     balance.searchInBalance(paymentMultiThread.getDebtor().getDepositAccountNumber()) - Double.parseDouble(paymentMultiThread.getDebtor().getDepositAmount())) )
                System.out.println("Transaction Complete");
        }
        else
            System.out.println("Transaction Not Possible");
    }
}

