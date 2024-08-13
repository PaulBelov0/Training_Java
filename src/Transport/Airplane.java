package src.Transport;

public class Airplane extends TransportBase{
    public Airplane(String[] args) {
        super(args);
        super.setType("Airplane");
        wingspan = Integer.parseInt(args[6]);
        maxCapacity = Integer.parseInt(args[7]);
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    private int wingspan;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    private int maxCapacity;
}
