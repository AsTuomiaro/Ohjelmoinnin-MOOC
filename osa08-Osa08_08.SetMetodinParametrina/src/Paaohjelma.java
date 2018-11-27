
import java.util.HashSet;
import java.util.Set;


public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testikoodia
        Set<String> nimet = new HashSet<>();
        nimet.add("eka");
        nimet.add("eka");
        nimet.add("toka");
        nimet.add("toka");
        nimet.add("toka");

        System.out.println(new JoukonTarkistin().palautaKoko(nimet));
    }

}
