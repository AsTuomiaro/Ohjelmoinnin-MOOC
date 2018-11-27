
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class GameOfLife {

    private Taulukko taulukko;

    public GameOfLife(int leveys, int korkeus) {
        this.taulukko = new Taulukko(leveys, korkeus);
    }

    public void alustaSatunnaisesti() {
        Random satunnaistaja = new Random();

        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                if (satunnaistaja.nextDouble() < 0.2) {
                    this.taulukko.aseta(x, y, true);
                }
            }
        }

    }

    public void kehity() {
        // säännöt kehittymiselle:

        // 1. jokainen elossa oleva alkio, jolla on alle 2 elossa olevaa naapuria kuolee
        // 2. jokainen elossa oleva alkio, jolla on 2 tai 3 elossa olevaa naapuria pysyy hengissä
        // 3. jokainen elossa oleva alkio, jolla on 4 tai enemmän naapureita kuolee
        // 4. jokainen kuollut alkio, jolla on tasan 3 naapuria muuttuu eläväksi
        // taulukossa arvo 1 kuvaa elävää alkiota, arvo 0 kuollutta alkiota
        Taulukko kopio = new Taulukko(taulukko.getLeveys(), taulukko.getKorkeus());
        for (int i = 0; i < taulukko.getLeveys(); i++) {
            for (int j = 0; j < taulukko.getKorkeus(); j++) {
                int elavatNaapurit = elossaOleviaNaapureita(taulukko, i, j);
                if (taulukko.hae(i, j)) {
                    if (elavatNaapurit == 2 || elavatNaapurit == 3) {
                        kopio.aseta(i, j, true);
                    }
                } else {
                    if (elavatNaapurit == 3) {
                        kopio.aseta(i, j, true);
                    }
                }
            }
        }
        setTaulukko(kopio);
    }

    public Taulukko getTaulukko() {
        return this.taulukko;
    }

    public void setTaulukko(Taulukko taulukko) {
        this.taulukko = taulukko;
    }

    public int elossaOleviaNaapureita(Taulukko taulukko, int x, int y) {
        int palautettava = 0;
        for (int i = x -1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y) && taulukko.hae(i, j)) {
                    palautettava++;
                }
            }
        }
        return palautettava;
    }
}
