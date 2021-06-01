import java.util.List;

public class Core {
    public static void main(String[] args) throws Exception {


        Payment payment = new Payment();
        Balance balance = new Balance();
        Transactions transactions ;

        List<Creditors> creditorsList = payment.getCreditorList();
        Debtor Debtor = payment.getDebtor();

        System.out.println("Debtor Account number is: (depositAccountNumber) : " + Debtor.depositAccountNumber );
        System.out.println("Debtor withdraw Amount is: (depositAmount)       : " + Debtor.depositAmount );
        System.out.println("Balance of Debtor is: " + balance.searchInBalance(Debtor.depositAccountNumber));

        if(balance.searchInBalance(Debtor.depositAccountNumber) >= Double.parseDouble(Debtor.depositAmount) ){
            System.out.println("Transaction Possible");
            for (Creditors creditor : creditorsList ) {
                System.out.println("Transfer to: " + creditor.getWithDrawAccountNumber() + " Amount to deposit is: " + creditor.getWithDrawAmount());
                double newAmount = Double.parseDouble(creditor.getWithDrawAmount()) +  balance.searchInBalance(creditor.withDrawAccountNumber);
                if(balance.editBalanceFile(creditor.getWithDrawAccountNumber(),balance.searchInBalance(creditor.withDrawAccountNumber), newAmount)) {
                    System.out.println("New Balance of " +creditor.withDrawAccountNumber + " is: " + balance.searchInBalance(creditor.withDrawAccountNumber));
                    transactions = new Transactions(creditor.withDrawAccountNumber, Debtor.depositAccountNumber,  Double.parseDouble(creditor.withDrawAmount));
                }
            }
        }
        else
            System.out.println("Transaction Not Possible");
    }
}

