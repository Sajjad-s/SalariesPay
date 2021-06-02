public class Debtor {
    String depositAccountNumber;

    public String getDepositAccountNumber() {
        return depositAccountNumber;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    String depositAmount;

    public Debtor(String depositAccountNumber, String depositAmount) {
        this.depositAccountNumber = depositAccountNumber;
        this.depositAmount = depositAmount;
    }
}
