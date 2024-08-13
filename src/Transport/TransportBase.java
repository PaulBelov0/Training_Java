package src.Transport;


public abstract class TransportBase {
    public TransportBase(String[] args) {
        uniqueID = Integer.parseInt(args[0]);
        brand = args[2];
        model = args[3];
        year = Integer.parseInt(args[4]);
        weight = Integer.parseInt(args[5]);
    }


    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    protected int uniqueID;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    protected String brand;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    protected String model;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    protected int year;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    protected int weight;
}
