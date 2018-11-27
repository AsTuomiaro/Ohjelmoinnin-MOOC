package kirjallisuutta;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Map<String, Integer> kirjat = new HashMap<>();
        
        while (true) {
            System.out.print("Syötä kirjan nimi, tyhjä lopettaa: ");
            String kirjanNimi = lukija.nextLine();
            
            if (kirjanNimi.isEmpty()) {
                break;
            }
            
            System.out.print("Syötä kirjan pienin kohdeikä: ");
            int kohdeika = Integer.parseInt(lukija.nextLine());
            
            System.out.println("");
            
            kirjat.putIfAbsent(kirjanNimi, kohdeika);
        }
        
        System.out.println("\nYhteensä " + kirjat.keySet().size() + " kirjaa.");
        System.out.println("\nKirjat: ");
        kirjat.keySet()
                .stream()
                .sorted((k1, k2) -> {
                    int s = kirjat.get(k1) - kirjat.get(k2);
                    if (s == 0) {
                        return k1.compareTo(k2);
                    }
                    return s;
                })
                .forEach(kirja -> 
                        System.out.println(kirja + " (" + kirjat.get(kirja) 
                                + " vuotiaille ja vanhemmille)"));
        

    }

}
