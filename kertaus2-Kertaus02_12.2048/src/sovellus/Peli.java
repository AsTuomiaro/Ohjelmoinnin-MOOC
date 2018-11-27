package sovellus;

import java.util.Scanner;

public class Peli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peliruudukko peliruudukko = new Peliruudukko();
        
        while (peliruudukko.peliKaynnissa()) {            
            int[][] ruudukko = peliruudukko.getTaulukko();
            for (int i = 0; i < ruudukko.length; i++) {
                for (int j = 0; j < ruudukko[i].length; j++) {
                    System.out.print(ruudukko[i][j] + " ");
                }
                System.out.println("");
            }
            
            System.out.print("\n> ");
            String syote = lukija.nextLine();
            
            if (syote.equals("x")) {
                break;
            } else if (syote.equals("o")) {
                peliruudukko.siirraOikealle();
                peliruudukko.arvoUusiLukupaikka();
            } else if (syote.equals("v")) {
                peliruudukko.siirraVasemmalle();
                peliruudukko.arvoUusiLukupaikka();
            } else if (syote.equals("y")) {
                peliruudukko.siirraYlos();
                peliruudukko.arvoUusiLukupaikka();
            } else if (syote.equals("a")) {
                peliruudukko.siirraAlas();
                peliruudukko.arvoUusiLukupaikka();
            } else {
                System.out.println("Tuntematon komento \n");
            }
        }
    }
}
