package com.apcs.unit7.searchingAndRemoving;
import java.util.HashMap;

public class Phone {
    private String model;
    private String color;
    private String[] phone1 = {"Iphone 13", "Red"};
    private String[] phone2 = {"Iphone 12", "White"};
    private String[] phone3 = {"Samsung Galaxy S10", "Green"};

    public Phone(String[] phoneStuff) {
        model = phoneStuff[0];
        color = phoneStuff[1];
    }

    public Phone(int ID) {
        HashMap<Integer, String[]> phoneID = new HashMap<>();
        phoneID.put(1111, phone1);
        phoneID.put(1234, phone2);
        phoneID.put(666, phone3);

        model = phoneID.get(ID)[0];
        color = phoneID.get(ID)[1];
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return "Model: " + model + " Color: " + color;
    }
}
