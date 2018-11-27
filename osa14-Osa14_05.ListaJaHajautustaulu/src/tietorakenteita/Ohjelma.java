package tietorakenteita;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ohjelma {

    public static void main(String[] args) {
        // voit testailla luokkiasi täällä
        Lista<String> lista = new Lista<>();
        Hajautustaulu<String, String> taulu = new Hajautustaulu<>();
        List<String> vertailu = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            lista.lisaa("" + i);
            vertailu.add("" + i);
            taulu.lisaa("" + i, "" + i);
        }

        Lista<String> haettavat = new Lista<>();
        Random arpoja = new Random();
        for (int i = 0; i < 1000; i++) {
            haettavat.lisaa("" + arpoja.nextInt(2000000));
        }

        long listanHakuAloitus = System.nanoTime();
        for (int i = 0; i < haettavat.koko(); i++) {
            lista.sisaltaa(haettavat.arvo(i));
        }
        long listanHakuLopetus = System.nanoTime();

        long listanHakuAloitus2 = System.nanoTime();
        for (int i = 0; i < haettavat.koko(); i++) {
            vertailu.contains(haettavat.arvo(i));
        }
        long listanHakuLopetus2 = System.nanoTime();
        
        long hajautustaulunHakuAloitus = System.nanoTime();
        for (int i = 0; i < haettavat.koko(); i++) {
            taulu.hae(haettavat.arvo(i));
        }
        long hajautustaulunHakuLopetus = System.nanoTime();

        long listanHaku = listanHakuLopetus - listanHakuAloitus;
        long listanHaku2 = listanHakuLopetus2 - listanHakuAloitus2;
        System.out.println("Lista: haku kesti noin " + listanHaku / 1000000 + " millisekuntia ("
                + listanHaku + " nanosekuntia.)");
        
        System.out.println("Lista: vertailtava haku kesti noin " + listanHaku2 / 1000000 + " millisekuntia ("
                + listanHaku2 + " nanosekuntia.)");

        long hajautustaulunHaku = hajautustaulunHakuLopetus - hajautustaulunHakuAloitus;
        System.out.println("Hajautustaulu: haku kesti noin " + hajautustaulunHaku / 1000000
                + " millisekuntia (" + hajautustaulunHaku + " nanosekuntia.)");
    }

    public static int osiaToteutettu() {
        return 3;
    }
}
