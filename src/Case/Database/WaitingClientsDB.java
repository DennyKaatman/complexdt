package Case.Database;

import Case.ScanData.WaitingClient;

import java.util.ArrayList;

public class WaitingClientsDB {
    public static ArrayList<WaitingClient> waitingClients = new ArrayList<>();

    public static String getWaitingClients() {
        return waitingClients.toString();
    }

    public static void add(WaitingClient waitingClient){
        waitingClients.add(waitingClient);
    }


}
