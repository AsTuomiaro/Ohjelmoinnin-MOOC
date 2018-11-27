
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        YlhaaltaRajoitettuLaskuri tunnit = new YlhaaltaRajoitettuLaskuri(23);
        YlhaaltaRajoitettuLaskuri minuutit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        
        
        // Tee tänne koodia jolla testaat että YlhaaltaRajoitettuLaskuri toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävän viimeisissä osissa ja käyttää 
        // tehtävänannossa ehdotettua koodirunkoa

        System.out.print("sekunnit: ");
        sekunnit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        
        System.out.print("minuutit: ");
        minuutit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        
        System.out.print("tunnit: ");
        tunnit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        
        int i = 0;
        while (i < 121) {            
            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            sekunnit.seuraava();
            if (sekunnit.arvo() == 0) {
                minuutit.seuraava();
            }
            if (sekunnit.arvo() == 0 && minuutit.arvo() == 0) {
                tunnit.seuraava();
            }
            i++;
        }
    }
}
