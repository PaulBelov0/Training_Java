package src.Database;

import src.Transport.Airplane;
import src.Transport.Boat;
import src.Transport.Car;
import src.Transport.TransportBase;
import src.TransportCreator.TransportCreator;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public Database() {
        fileName = "database.txt";
        file = new File(fileName);
        try {
            file.createNewFile();
            writer = new FileWriter(file, true);
            reader = new FileReader(file);
        } catch (IOException e) {
        }
    }

    public void serialize(List<TransportBase> storage) {
        for (int i = 0; i < storage.size(); ++i) {
            setObjectFields(storage.get(i));
        }
    }

    public List<TransportBase> deserialize() {
        List<TransportBase> outputList = new ArrayList<>();
        if (readElement() != null)
            outputList.add(readElement());

        return outputList;
    }

    private void setObjectFields(TransportBase obj) {

        String objectData = Integer.toString(obj.getUniqueID()) + "/";
        objectData += obj.getType() + "/";
        objectData += obj.getBrand() + "/";
        objectData += obj.getModel() + "/";
        objectData += Integer.toString(obj.getYear()) + "/";
        objectData += Integer.toString(obj.getWeight()) + "/";

        switch (obj.getType()) {
            case "Car":
                Car carTmp = new Car((Car) obj);
                objectData += Integer.toString(carTmp.getMileage()) + "/";
                objectData += Integer.toString(carTmp.getOwnersQuantity()) + "\n";
                writeElement(objectData);
                break;

            case "Boat":
                Boat boatTmp = new Boat((Boat) obj);
                objectData += Integer.toString(boatTmp.getDisplacement()) + "/";
                objectData += Integer.toString(boatTmp.getLength()) + "\n";
                writeElement(objectData);
                break;

            case "Airplane":
                Airplane airTmp = new Airplane((Airplane) obj);
                objectData += Integer.toString(airTmp.getWingspan()) + "/";
                objectData += Integer.toString(airTmp.getMaxCapacity()) + "\n";
                writeElement(objectData);
                break;
        }
    }

    private void writeElement(String raw) {
        try {
            writer.write(raw);
        } catch (IOException e) {
        }
    }

    private TransportBase readElement() {
        String[] args = new String[7];
        if (file.length() != 0) {
            for (int i = 0; i < args.length; ++i)
                try {
                    while (reader.read() != "/".codePointAt(0)) {
                        args[i] += reader.getEncoding();
                    }
                } catch (IOException e) {
                }
            TransportCreator creator = new TransportCreator(args);
            return creator.getTransportObject();
        } else {
            return null;
        }
    }

    private String readElementDataRaw() {
        String data = "";
        int eof = -1;
        try {
            while (reader.read() != eof) {
                while (reader.read() != Integer.parseInt("\n")) {
                    data = reader.getEncoding().toString();
                }
            }
        } catch (IOException e) {
        }
        return data;
    }

    private File file;
    private FileWriter writer;
    private FileReader reader;
    private String fileName;
}
