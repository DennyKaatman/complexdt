package Case;

import Case.Database.ComplaintsDB;
import Case.Database.HomesDB;
import Case.Database.WaitingClientsDB;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new Reader();
        reader.startReader(new File("src/Assignment1/Data/Complaints.csv"));
        reader.startReader(new File("src/Assignment1/Data/Homes.csv"));
        reader.startReader(new File("src/Assignment1/Data/Waitinglist.csv"));

        System.out.println(ComplaintsDB.getComplaintsList());
        System.out.println(HomesDB.getHomesList());
        System.out.println(WaitingClientsDB.getWaitingClients());
    }
}
