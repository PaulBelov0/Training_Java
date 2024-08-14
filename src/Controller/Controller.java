package src.Controller;

import src.Transport.Airplane;
import src.Transport.Boat;
import src.Transport.Car;
import src.Transport.TransportBase;
import src.TransportCreator.TransportCreator;
import src.TransportStorage.TransportStorage;
import src.Database.Database;

import java.util.Iterator;

public class Controller {

    public Controller() {
        db = new Database();
        storage = new TransportStorage(db.deserialize());
    }

    public void addNewElement(String[] args) {
        TransportCreator creator = new TransportCreator(args);
        storage.addElement(creator.getTransportObject());
    }

    public void deleteElement(int uniqueID) {
        if (checkElementAvailable(uniqueID))
            storage.deleteElement(uniqueID);
        else
            System.out.println("Error! No one element have this ID!");
    }

    public void showDatabase() {
        if (!storage.getList().isEmpty()) {

            Iterator<TransportBase> element = storage.getList().iterator();
            while (element.hasNext()) {
                printElementFields(element.next());
            }
        } else
            System.out.println("Database is empty!");
    }

    public void showElement(int ID) {

        if (checkElementAvailable(ID))
            for (int i = 0; i < storage.getList().size(); ++i) {
                if (storage.getList().get(i).getUniqueID() == ID) {
                    printElementFields(storage.getList().get(i));
                }
            }
        else
            System.out.println("Error! No one element have this ID!");
    }

    public boolean checkElementAvailable(int ID) {
        boolean isAvailable = false;
        for (int i = 0; i < storage.getList().size(); ++i) {
            if (storage.getList().get(i).getUniqueID() == ID) {
                isAvailable = true;
            }
        }

        if (isAvailable) {
            return true;
        } else {
            return false;
        }
    }

    public void serializeStorage() {
        db.serialize(storage.getList());
    }

    private void printElementFields(TransportBase element) {
        System.out.println("\n\nID:\t#" + element.getUniqueID());
        System.out.println("Type:\t" + element.getType());
        System.out.println("Brand:\t" + element.getBrand());
        System.out.println("Model:\t" + element.getModel());
        System.out.println("Year:\t" + element.getYear());
        System.out.println("Weight:\t" + element.getWeight());

        switch (element.getType()) {
            case "Car":
                Car carTmp = ((Car) element);
                System.out.println("Mileage:\t" + carTmp.getMileage());
                System.out.println("Owners quantity:\t" + carTmp.getOwnersQuantity());
                break;
            case "Boat":
                Boat boatTmp = ((Boat) element);
                System.out.println("Displacement:\t" + boatTmp.getDisplacement());
                System.out.println("Lenght:\t" + boatTmp.getLength());
                break;
            case "Airplane":
                Airplane airTmp = ((Airplane) element);
                System.out.println("Wingspan:\t:" + airTmp.getWingspan());
                System.out.println("Max capacity:\t" + airTmp.getMaxCapacity());
                break;
        }
    }

    private TransportStorage storage;
    private Database db;
}
