public class Creditors {
    public Creditors(String creditorAccountNumber, String withDrawAmount) {
        this.creditorAccountNumber = creditorAccountNumber;
        this.withDrawAmount = withDrawAmount;
    }

    public String getCreditorAccountNumber() {
        return creditorAccountNumber;
    }

    public String getWithDrawAmount() {
        return withDrawAmount;
    }

    String creditorAccountNumber;
    String withDrawAmount;

}
