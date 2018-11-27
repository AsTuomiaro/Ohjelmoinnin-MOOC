package numerotiedustelu;

import java.util.Scanner;
import numerotiedustelu.logiikka.Numerokeskus;
import numerotiedustelu.ui.Kayttoliittyma;


public class Paaohjelma {

    public static void main(String[] args) {
        // tee tästä ohjelmasi käynnistyspiste
        // HUOM: ohjelmassa saa luoda Scanner-olion vain kertaalleen
        Scanner lukija = new Scanner(System.in);
        Numerokeskus keskus = new Numerokeskus();
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija, keskus);
        kayttis.kaynnista();
    }
}
