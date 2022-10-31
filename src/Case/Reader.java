package Case;

import Case.Database.ComplaintsDB;
import Case.Database.HomesDB;
import Case.Database.WaitingClientsDB;
import Case.ScanData.Complaints;
import Case.ScanData.Home;
import Case.ScanData.WaitingClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public void startReader(File file) throws FileNotFoundException {
        Scanner fileReader = new Scanner(file);
        fileReader.nextLine();

        do {
            String line = fileReader.nextLine();
            String[] lineParts = line.split(";");

            switch (file.getName()) {
                case "Complaints.csv"   -> ComplaintsDB.add(createComplaint(lineParts));
                case "Homes.csv"        -> HomesDB.add(createHome(lineParts));
                case "Waitinglist.csv"  -> WaitingClientsDB.add(createWaitingClient(lineParts));
            }

        } while (fileReader.hasNext());

        fileReader.close();
    }

    private Complaints createComplaint(String[] lineParts){
        int ComplaintID = Integer.parseInt(lineParts[0]);
        int HomeID = Integer.parseInt(lineParts[1]);
        String Category = String.valueOf(lineParts[2]);
        int EstimatedTimeMin = Integer.parseInt(lineParts[3]);
        int ActualTimeMin = 0;
        int OtherCosts = 0;
        if (lineParts.length == 6){
            ActualTimeMin = Integer.parseInt(lineParts[4]);
            OtherCosts = Integer.parseInt(lineParts[5]);
        }

        return new Complaints(
                ComplaintID, HomeID, Category, EstimatedTimeMin, ActualTimeMin, OtherCosts);
    }
    private Home createHome(String[] lineParts){
        int HomeID = Integer.parseInt(lineParts[0]);
        int AddressX = Integer.parseInt(lineParts[1]);
        int AddressY = Integer.parseInt(lineParts[2]);
        int Rent = Integer.parseInt(lineParts[3]);
        int NrOfRooms = Integer.parseInt(lineParts[4]);
        boolean Garden = Boolean.parseBoolean(lineParts[5]);

        return new Home(
                HomeID, AddressX, AddressY, Rent, NrOfRooms, Garden);
    }
    private WaitingClient createWaitingClient(String[] lineParts){
        int ClientID = Integer.parseInt(lineParts[0]);
        String Name = String.valueOf(lineParts[1]);
        String Initials = String.valueOf(lineParts[2]);
        int Urgency = Integer.parseInt(lineParts[3]);
        int NrOfRooms = Integer.parseInt(lineParts[4]);
        boolean Garden = Boolean.parseBoolean(lineParts[5]);

        return new WaitingClient(
                ClientID, Name, Initials, Urgency, NrOfRooms, Garden);
    }
}

