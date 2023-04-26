import java.rmi.RemoteException;

public class RemoteImpl implements IRemote {

    private String message;

    public RemoteImpl() throws RemoteException {
        this("Hello, world!");
    }

    public RemoteImpl(String message) throws RemoteException {
        setMessage(message);
    }

    @Override
    public String getMessage() throws RemoteException {
        return message;
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        this.message = message;
    }

}


