package server;

import protocol.Constants;
import protocol.RemoteCommand;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class MainServer {

    List<Cat> cats;

    public MainServer() {
        this.cats = new ArrayList<>();
    }

    public static void main(String args[]) {

        MainServer mainServer = new MainServer();

        try {
            RemoteCommand getCats = new GetCats(mainServer);
            RemoteCommand postCat = new PostCat(mainServer);

            Registry registry = LocateRegistry.createRegistry(Constants.HOST_PORT);

            registry.rebind(Constants.GET_CATS_FUN, getCats);
            registry.rebind(Constants.POST_CAT_FUN, postCat);

            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }



}
