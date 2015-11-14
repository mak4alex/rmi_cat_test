package client;

import protocol.Constants;
import protocol.RemoteCommand;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;


public class MainClient {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry(Constants.HOST_NAME, Constants.HOST_PORT);

            RemoteCommand postCat = (RemoteCommand) registry.lookup(Constants.POST_CAT_FUN);
            RemoteCommand getCats = (RemoteCommand) registry.lookup(Constants.GET_CATS_FUN);

            postCat.execute("Kitty", 10);
            postCat.execute("George", 2);
            postCat.execute("Honey", 5);


            List<String> cats = getCats.execute();

            for (String cat : cats) {
                System.out.println(cat);
            }

        } catch (Exception e) {
            System.err.println("exception:");
            e.printStackTrace();
        }

    }

}
