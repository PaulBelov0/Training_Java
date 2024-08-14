package src.Transport;

public class Car extends TransportBase{
    public Car(String[] args) {
        super(args);
        super.setType("Car");
        mileage = Integer.parseInt(args[6]);
        ownersQuantity = Integer.parseInt(args[7]);
    }

    public Car(Car obj) {
        super(obj);
        super.type = "Car";
        this.mileage = obj.mileage;
        this.ownersQuantity = obj.ownersQuantity;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    private int mileage;

    public int getOwnersQuantity() {
        return ownersQuantity;
    }

    public void setOwnersQuantity(int ownersQuantity) {
        this.ownersQuantity = ownersQuantity;
    }

    private int ownersQuantity;
}
