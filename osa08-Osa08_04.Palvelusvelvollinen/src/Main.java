
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Testaa koodiasi täällä!
        
        Sivari heikki = new Sivari();
        Asevelvollinen simo = new Asevelvollinen(180);
        
        ArrayList<Palvelusvelvollinen> velvolliset = new ArrayList<>();
        velvolliset.add(simo);
        velvolliset.add(heikki);
        
        for (int i = 0; i < 100; i++) {
            for (Palvelusvelvollinen h : velvolliset) {
                h.palvele();
            }
        }
        
        System.out.println("Heikillä päiviä jäljellä: " + heikki.paiviaJaljella());
        System.out.println("Simolla päiviä jäljellä: " + simo.paiviaJaljella());
        System.out.println("Ei mene nallekarkit tasan Suomen maassa.");
    }
}
