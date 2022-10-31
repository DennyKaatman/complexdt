package Case.ScanData;

public class WaitingClient implements Comparable<WaitingClient>{
    private int ClientID;
    private String Name;
    private String Initials;
    private int Urgency;
    private int NrOfRooms;
    private boolean Garden;

    public WaitingClient(int clientID, String name, String initials, int urgency, int nrOfRooms, boolean garden) {
        this.ClientID = clientID;
        this.Name = name;
        this.Initials = initials;
        this.Urgency = urgency;
        this.NrOfRooms = nrOfRooms;
        this.Garden = garden;
    }

    public int getUrgency() {
        return Urgency;
    }

    public int getClientID() {
        return ClientID;
    }

    public void setClientID(int clientID) {
        ClientID = clientID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String initials) {
        Initials = initials;
    }

    public void setUrgency(int urgency) {
        Urgency = urgency;
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
        return "WaitingClient{" +
                "ClientID=" + ClientID +
                ", Name='" + Name + '\'' +
                ", Initials='" + Initials + '\'' +
                ", Urgency=" + Urgency +
                ", NrOfRooms=" + NrOfRooms +
                ", Garden=" + Garden +
                '}';
    }

    @Override
    public int compareTo(WaitingClient o) {
        return Integer.compare(this.Urgency, o.getUrgency());
    }
}
