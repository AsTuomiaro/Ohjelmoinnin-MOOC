package kolmeyleisinta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        
        List<String> sanoja = new ArrayList<>();
        sanoja.add("eka");
        sanoja.add("eka");
        sanoja.add("toka");
        sanoja.add("eka");
        sanoja.add("toka");
        sanoja.add("kolmas");
        sanoja.add("toka");
        sanoja.add("toka");
        sanoja.add("toka");
        sanoja.add("kolmas");
        sanoja.add("eka");
        sanoja.add("kolmas");
        sanoja.add("toka");
        sanoja.add("kolmas");
        sanoja.add("eka");
        sanoja.add("kolmas");
        sanoja.add("eka");
        
        List<String> yleisimmat = new YleisimmatSanat1().yleisetSanat(sanoja);
        
        System.out.println("Yleisimmät olivat: ");
        for (int i = 0; i < yleisimmat.size(); i++) {
            System.out.println((i + 1) + ": " + yleisimmat.get(i));
        }
    }

}
