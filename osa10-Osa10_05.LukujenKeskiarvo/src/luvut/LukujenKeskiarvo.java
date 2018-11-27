package luvut;


import java.util.ArrayList;
import java.util.Scanner;

public class LukujenKeskiarvo {

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
        
        double keskiarvo = luvut.stream()
                .mapToInt(arvo -> Integer.parseInt(arvo))
                .average().getAsDouble();
        
        System.out.println("Lukujen keskiarvo: " + keskiarvo);
    }
}
