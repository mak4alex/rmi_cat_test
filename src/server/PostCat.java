package server;

import protocol.RemoteCommand;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by MAA on 14.11.15.
 */
public class PostCat extends UnicastRemoteObject implements RemoteCommand, Serializable {

    private static final long serialVersionUID = 227L;


    MainServer mainServer;

    public PostCat() throws RemoteException {
        super();
    }

    public PostCat(MainServer mainServer) throws RemoteException {
        super();
        this.mainServer = mainServer;
    }

    @Override
    public <T> T execute(T... params) throws RemoteException {
        mainServer.cats.add(new Cat((String)params[0], (Integer)params[1]));
        return null;
    }

}