import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            Calc obj = (Calc) Naming.lookup("rmi://localhost/CalcService");

            int result = obj.operation("hello");

            System.out.println("Vowels = " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}