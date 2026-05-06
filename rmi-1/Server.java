import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            Calc obj = new CalcImpl();
            Naming.rebind("rmi://localhost/CalcService", obj);
            System.out.println("Server ready...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}