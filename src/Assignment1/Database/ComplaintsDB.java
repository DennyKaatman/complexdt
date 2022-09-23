package Assignment1.Database;

import Assignment1.ScanData.Complaints;

import java.util.ArrayList;

public class ComplaintsDB {
    public static ArrayList<Complaints> complaintsList = new ArrayList<>();

    public static String getComplaintsList() {
        return complaintsList.toString();
    }

    public static void add(Complaints complaints){
        complaintsList.add(complaints);
    }

}
