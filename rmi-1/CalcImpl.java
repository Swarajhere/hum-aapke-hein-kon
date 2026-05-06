import java.rmi.*;
import java.rmi.server.*;

public class CalcImpl extends UnicastRemoteObject implements Calc {

    public CalcImpl() throws RemoteException {
        super();
    }

    public int operation(String str) throws RemoteException {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                count++;
        }
        return count;
    }
}