package pack;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Osoba osoba1= null, osoba2= null, osoba3= null, osoba4= null;
        Firma firma1= null, firma2= null, firma3= null, firma4= null;

        try {
            osoba1 = new Osoba("Tomasz", "Sagan", "Lódz", 42, 555666777);
            osoba2 = new Osoba("Maciej", "Nowak", "Warszawa", 43, 666777888);
            osoba3 = new Osoba("Piotr", "Kowalski", "Poznan", 44, 654654654);
            osoba4 = new Osoba("Pawel", "Stary", "Krakow", 45, 645645645);

            firma1 = new Firma("Dobra","Lódz",42,500600700);
            firma2 = new Firma("Nowa","Warszawa",43,600500700);
            firma3 = new Firma("Tania","Gdansk",46,560650560);
            firma4 = new Firma("Szybka","Kielce",47,670760444);


        } catch (WrongLengthOfPhoneNumber wrongLengthOfPhoneNumber) {
            wrongLengthOfPhoneNumber.printStackTrace();
        }

        TreeMap<NrTelefoniczny,Wpis> treeMap = new TreeMap<>();

        treeMap.put(osoba1.getNrTelefoniczny(),osoba1);
        treeMap.put(osoba2.getNrTelefoniczny(),osoba2);
        treeMap.put(osoba3.getNrTelefoniczny(),osoba3);
        treeMap.put(osoba4.getNrTelefoniczny(),osoba4);

        treeMap.put(firma1.getNrTelefoniczny(),firma1);
        treeMap.put(firma2.getNrTelefoniczny(),firma2);
        treeMap.put(firma3.getNrTelefoniczny(),firma3);
        treeMap.put(firma4.getNrTelefoniczny(),firma4);

        for (var val : treeMap.entrySet())
        {
            System.out.println(val.getValue().opis());
        }

    }
}
