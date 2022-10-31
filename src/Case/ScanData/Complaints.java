package Case.ScanData;

public class Complaints {
    private int ComplaintID;
    private int HomeID;
    private String Category;
    private int EstimatedTimeMin;
    private int ActualTimeMin;
    private int OtherCosts;

    public Complaints(int complaintID, int homeID, String category, int estimatedTimeMin, int actualTimeMin, int otherCosts) {
        this.ComplaintID = complaintID;
        this.HomeID = homeID;
        this.Category = category;
        this.EstimatedTimeMin = estimatedTimeMin;
        this.ActualTimeMin = actualTimeMin;
        this.OtherCosts = otherCosts;
    }

    public int getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(int complaintID) {
        ComplaintID = complaintID;
    }

    public int getHomeID() {
        return HomeID;
    }

    public void setHomeID(int homeID) {
        HomeID = homeID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getEstimatedTimeMin() {
        return EstimatedTimeMin;
    }

    public void setEstimatedTimeMin(int estimatedTimeMin) {
        EstimatedTimeMin = estimatedTimeMin;
    }

    public int getActualTimeMin() {
        return ActualTimeMin;
    }

    public void setActualTimeMin(int actualTimeMin) {
        ActualTimeMin = actualTimeMin;
    }

    public int getOtherCosts() {
        return OtherCosts;
    }

    public void setOtherCosts(int otherCosts) {
        OtherCosts = otherCosts;
    }

    @Override
    public String toString() {
        return "Complaints{" +
                "ComplaintID=" + ComplaintID +
                ", HomeID=" + HomeID +
                ", Category='" + Category + '\'' +
                ", EstimatedTimeMin=" + EstimatedTimeMin +
                ", ActualTimeMin=" + ActualTimeMin +
                ", OtherCosts=" + OtherCosts +
                '}';
    }
}
