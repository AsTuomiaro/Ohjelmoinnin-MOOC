package mittaustentasoitus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        List<Henkilo> tyypit = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            tyypit.add(new Henkilo("Nimetön", 1.3 + rnd.nextDouble(), 
                    45 + rnd.nextInt(51), 50 + rnd.nextInt(36)));
        }
        
        List<Double> mittaukset = new MittaustenTasoittaja1().tasoita(tyypit);
        List<Double> mittaukset2 = new MittaustenTasoittaja2().tasoita(tyypit);
        for (int i = 0; i < tyypit.size(); i++) {
            System.out.println("Mittaus: " + tyypit.get(i).getSyke() 
                    + "; Tasoitus 1: " + String.format("%.2f", mittaukset.get(i)) 
                    + "; Tasoitus 2: " + String.format("%.2f", mittaukset2.get(i)));
        }
        
        System.out.println("Mittaukset 1 koko: " + mittaukset.size());
        System.out.println("Mittaukset 2 koko: " + mittaukset2.size());
    }

}
