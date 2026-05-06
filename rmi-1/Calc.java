import java.rmi.*;

public interface Calc extends Remote {
    public int operation(String str) throws RemoteException;
}