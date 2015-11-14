package protocol;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteCommand extends Remote {

     <T> T execute(T... params) throws RemoteException;

}
