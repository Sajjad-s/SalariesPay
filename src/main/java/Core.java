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
                System.out.println("Transfer to: " + creditor.getCreditorAccountNumber() + " Amount to deposit is: " + creditor.getWithDrawAmount());
                double newDebotorsAmount = Double.parseDouble(creditor.getWithDrawAmount()) +  balance.searchInBalance(creditor.creditorAccountNumber);
                if(balance.editBalanceFile(creditor.getCreditorAccountNumber(),balance.searchInBalance(creditor.creditorAccountNumber), newDebotorsAmount)) {
                    System.out.println("New Balance of " +creditor.creditorAccountNumber + " is: " + balance.searchInBalance(creditor.creditorAccountNumber));
                    transactions = new Transactions(creditor.creditorAccountNumber, Debtor.depositAccountNumber,  Double.parseDouble(creditor.withDrawAmount));
                }
            }
            if(balance.editBalanceFile(payment.getDebtor().getDepositAccountNumber(),
                    balance.searchInBalance(Debtor.getDepositAccountNumber()) ,
                     balance.searchInBalance(payment.getDebtor().getDepositAccountNumber()) - Double.parseDouble(payment.getDebtor().getDepositAmount())) )
                System.out.println("Transaction Complete");
        }
        else
            System.out.println("Transaction Not Possible");
    }
}

