package makihyppy;

import java.util.Scanner;
import makihyppy.ui.Kayttoliittyma;


public class Main {

    public static void main(String[] args) {
        // Kirjoita pääohjelma tänne. Omien luokkien tekeminen on erittäin hyödyllistä.
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija);
        kayttis.kaynnista();
    }
}
