package tietytluvut;

import java.util.ArrayList;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> luvut = new ArrayList<>();
        // toteuta ohjelmasi tänne

        System.out.println("Kirjoita syötteitä, \"loppu\" lopettaa.");
        
        while (true) {            
            String syote = lukija.nextLine();
            if (syote.equals("loppu")) {
                break;
            }
            luvut.add(syote);
        }
        
        System.out.println("\nTulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p)");
        String uusiSyote = lukija.nextLine();
        
        if (uusiSyote.equals("n")) {
            double negatiivistenKeskiarvo = luvut.stream()
                    .mapToInt(arvo -> Integer.parseInt(arvo))
                    .filter(arvo -> arvo < 0)
                    .average().getAsDouble();
            
            System.out.println("Negatiivisten lukujen keskiarvo: " + negatiivistenKeskiarvo);
        } else {
            double positiivistenKeskiarvo = luvut.stream()
                    .mapToInt(arvo -> Integer.parseInt(arvo))
                    .filter(arvo -> arvo > 0)
                    .average().getAsDouble();
            
            System.out.println("Positiivisten lukujen keskiarvo: " + positiivistenKeskiarvo);
        }
    }
}
