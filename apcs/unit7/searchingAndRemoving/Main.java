package apcs.unit7.searchingAndRemoving;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();

        phones.add(new Phone(1111));
        phones.add(new Phone(1234));
        phones.add(new Phone(666));
        String[] phone = {"Iphone 7", "Space Gray"};
        phones.add(new Phone(phone));

        RemoveRed(FindRed(phones), phones);
        System.out.println(phones);
    }

    public static ArrayList<Integer> FindRed(ArrayList<Phone> phones) {
        ArrayList<Integer> phonesWithRed = new ArrayList<>();

        for(int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getColor().equals("Red")) {
                phonesWithRed.add(i);
            }
        }
        return phonesWithRed; 
    }

    public static ArrayList<Phone> RemoveRed(ArrayList<Integer> phonesWithRed, ArrayList<Phone> phones) {
        for(int i = 0; i < phonesWithRed.size(); i++) {
            phones.remove(phones.get(phonesWithRed.get(i)));
        }
        return phones;
    }
}
