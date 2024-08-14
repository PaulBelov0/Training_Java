package src;

import src.Controller.Controller;

import java.util.Scanner;

import java.lang.NumberFormatException;
import java.lang.InterruptedException;

import java.lang.Thread;

public class Menu {
    private int uniqueID = 0;
    private int editingID;
    Controller controller;

    public void mainProcedure() {

        String userMessage;

        controller = new Controller();

        while (true) {
            System.out.println("\nSelect your action:\n\n1) Add new element.\n2) Delete element." +
                    "\n3) Show database.\n4) Edit element.\n5) Exit.\n\n");

            userMessage = console.nextLine();

            if (!checkConvertibleToInt(userMessage)) {

                throwError();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            } else
                switch (Integer.parseInt(userMessage)) {
                    case 1:
                        uniqueID++;
                        controller.addNewElement(enterElementFields(false));
                        break;
                    case 2:
                        controller.deleteElement(enterElementID());
                        break;
                    case 3:
                        controller.showDatabase();
                        System.out.println("\nPress Enter to continue...\n");
                        console.nextLine();
                        break;
                    case 4:
                        editElement();
                        break;
                    case 5:
                        controller.serializeStorage();
                        return;
                    default:
                        break;
                }
        }
    }

    private boolean checkConvertibleToInt(String raw) {
        try {
            Integer.parseInt(raw);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void throwError() {
        System.getProperty("\033[H\033[2J");
        System.out.println("Unsupported data!!!\n\n");
        System.getProperty("\033[H\033[2J");
    }

    private String[] enterElementFields(boolean editing) {
        String[] args = new String[8];

        if (editing == true)
            args[0] = Integer.toString(editingID);
        else
            args[0] = Integer.toString(uniqueID);

        args[1] = enterType();
        args[2] = enterField("brand");
        args[3] = enterField("model");

        args[4] = enterIntegerField("year");
        args[5] = enterIntegerField("weight");

        switch (Integer.parseInt(args[1])) {
            case 1:
                args[6] = enterIntegerField("mileage");
                args[7] = enterIntegerField("owners quantity");
                break;
            case 2:
                args[6] = enterIntegerField("displacement");
                args[7] = enterIntegerField("length");
                break;
            case 3:
                args[6] = enterIntegerField("wingspan");
                args[7] = enterIntegerField("max capacity");
                break;
        }
        return args;
    }

    Scanner console = new Scanner(System.in);

    private String enterType() {
        String userInput;

        while (true) {
            System.out.println("Select a type of transport:\n\n1) Car.\n2) Boat.\n3) Airplane.\n\n");
            userInput = console.nextLine();

            if (!checkConvertibleToInt(userInput)) {
                throwError();
            } else {
                if (Integer.parseInt(userInput) < 4 && Integer.parseInt(userInput) > 0)
                    return userInput;
                else
                    throwError();
            }
        }
    }


    private String enterField(String typeField) {
        System.out.println("Enter the " + typeField + " of transport:\t");
        return console.nextLine();
    }

    private String enterIntegerField(String typeField) {
        String field;
        while (true) {
            System.out.println("Enter the " + typeField + " of transport:\t");
            field = console.nextLine();

            if (checkConvertibleToInt(field))
                if (Integer.parseInt(field) > 0)
                    break;
        }
        return field;
    }

    private void editElement() {
        editingID = enterElementID();
        controller.showElement(editingID);
        controller.deleteElement(editingID);
        controller.addNewElement(enterElementFields(true));
    }

    private int enterElementID() {
        while (true) {
            String userMessage;
            System.out.println("Enter the element ID:\t");
            userMessage = console.nextLine();

            if (checkConvertibleToInt(userMessage)) {
                if (Integer.parseInt(userMessage) > 0)
                    return Integer.parseInt(userMessage);
                else throwError();
            } else {
                throwError();
            }
        }
    }
}

