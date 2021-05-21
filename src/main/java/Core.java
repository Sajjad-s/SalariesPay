import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Core {
    public static void main(String[] args) throws Exception {

//        Balance balance = new Balance();
//        System.out.println(balance.searchInBalance("1.10.100.2"));
        Payment payment = new Payment();
        payment.paymentToJson();


    }
}
