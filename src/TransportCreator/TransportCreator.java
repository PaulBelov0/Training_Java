package src.TransportCreator;

import src.Transport.Airplane;
import src.Transport.Boat;
import src.Transport.Car;
import src.Transport.TransportBase;

public class TransportCreator {
    public TransportCreator(String[] args) {
        switch (Integer.parseInt(args[1])) {
            case 1:
                obj = new Car(args);
                break;
            case 2:
                obj = new Boat(args);
                break;
            case 3:
                obj = new Airplane(args);
                break;
        }
    }

    public TransportBase getTransportObject() {
        return obj;
    }
    TransportBase obj;
}
