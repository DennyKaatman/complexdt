package Assignment1.Database;

import Assignment1.ScanData.Home;

import java.util.ArrayList;

public class HomesDB {
    public static ArrayList<Home> homesList = new ArrayList();

    public static String getHomesList() {
        return homesList.toString();
    }

    public static void add(Home home){
        homesList.add(home);
    }
}
