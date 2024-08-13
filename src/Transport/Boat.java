package src.Transport;

public class Boat extends TransportBase {
    public Boat(String[] args) {
        super(args);
        super.setType("Boat");
        displacement = Integer.parseInt(args[6]);
        length = Integer.parseInt(args[7]);
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    private int displacement;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;
}
