package server;

import protocol.RemoteCommand;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAA on 14.11.15.
 */
public class GetCats extends UnicastRemoteObject implements RemoteCommand, Serializable {

    private static final long serialVersionUID = 228L;


    MainServer mainServer;

    public GetCats() throws RemoteException {
        super();
    }

    public GetCats(MainServer mainServer) throws RemoteException {
        super();
        this.mainServer = mainServer;
    }

    @Override
    public <T> T execute(T... params) throws RemoteException {

        List<String> cats = new ArrayList<>();

        for (Cat cat : mainServer.cats) {
            cats.add(cat.toString());
        }

        return (T) cats;
    }
}
