package src.TransportStorage;

import src.Transport.TransportBase;

import java.util.*;

public class TransportStorage {

    public TransportStorage(List<TransportBase> inputList) {
        transportList = new ArrayList<>(inputList);
    }

    public void addElement(TransportBase element) {
        transportList.add(element);
    }

    public void deleteElement(int uniqueID) {

        for (int i = 0; i < transportList.size(); ++i) {
            if (transportList.get(i).getUniqueID() == uniqueID)
                transportList.remove(transportList.get(i));
        }
    }

    public List<TransportBase> getList() {
        return transportList;
    }

    private final List<TransportBase> transportList;
}
