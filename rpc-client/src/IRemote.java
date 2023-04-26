import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemote extends Remote {

    String getMessage() throws RemoteException;
    void setMessage(String message) throws RemoteException;

}
