package Assignment1;

import Assignment1.Database.ComplaintsDB;
import Assignment1.Database.HomesDB;
import Assignment1.Database.WaitingClientsDB;
import Assignment1.ScanData.Complaints;
import Assignment1.ScanData.WaitingClient;

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
