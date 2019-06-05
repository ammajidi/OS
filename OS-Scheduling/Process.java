public class Process {
    private int ID;
    private int arrivalTime;
    private int burstTime;

    public Process(int ID, int arrivalTime, int burstTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public String toString() {
        return "P" + ID ;
//                ", arrivalTime= " + arrivalTime +
//                ", burstTime= " + burstTime +
//                '}';
    }
}
