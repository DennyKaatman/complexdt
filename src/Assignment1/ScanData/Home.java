package Assignment1.ScanData;

public class Home {
    private int HomeID;
    private int AddressX;
    private int AddressY;
    private int Rent;
    private int NrOfRooms;
    private boolean Garden;

    public Home(int homeID, int addressX, int addressY, int rent, int nrOfRooms, boolean garden) {
        this.HomeID = homeID;
        this.AddressX = addressX;
        this.AddressY = addressY;
        this.Rent = rent;
        this.NrOfRooms = nrOfRooms;
        this.Garden = garden;
    }

    public int getHomeID() {
        return HomeID;
    }

    public void setHomeID(int homeID) {
        HomeID = homeID;
    }

    public int getAddressX() {
        return AddressX;
    }

    public void setAddressX(int addressX) {
        AddressX = addressX;
    }

    public int getAddressY() {
        return AddressY;
    }

    public void setAddressY(int addressY) {
        AddressY = addressY;
    }

    public int getRent() {
        return Rent;
    }

    public void setRent(int rent) {
        Rent = rent;
    }

    public int getNrOfRooms() {
        return NrOfRooms;
    }

    public void setNrOfRooms(int nrOfRooms) {
        NrOfRooms = nrOfRooms;
    }

    public boolean isGarden() {
        return Garden;
    }

    public void setGarden(boolean garden) {
        Garden = garden;
    }

    @Override
    public String toString() {
        return "Home{" +
                "HomeID=" + HomeID +
                ", AddressX=" + AddressX +
                ", AddressY=" + AddressY +
                ", Rent=" + Rent +
                ", NrOfRooms=" + NrOfRooms +
                ", Garden=" + Garden +
                '}';
    }
}
