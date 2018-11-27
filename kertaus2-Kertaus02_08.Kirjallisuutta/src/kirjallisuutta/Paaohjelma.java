package kirjallisuutta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<Kirja> kirjat = new ArrayList<>();
        
        while (true) {            
            System.out.print("Syötä kirjan nimi, tyhjä lopettaa: ");
            String syote = lukija.nextLine();
            if (syote.isEmpty()) {
                break;
            }
            
            System.out.print("Syötä kirjan pienin kohdeikä: ");
            int kohdeika = Integer.parseInt(lukija.nextLine());
            kirjat.add(new Kirja(syote, kohdeika));
            System.out.println("");
        }
        
        System.out.println("\nYhteensä " + kirjat.size() + " kirjaa.");
        System.out.println("\nKirjat: ");
        kirjat.stream().sorted((t, t1) -> {
            int kohdeikaErotus = t.getKohdeika() - t1.getKohdeika();
            if (kohdeikaErotus == 0) {
                return t.getNimi().compareTo(t1.getNimi());
            }
            return kohdeikaErotus;
        }).forEach(kirja -> System.out.println(kirja));
    }

}
