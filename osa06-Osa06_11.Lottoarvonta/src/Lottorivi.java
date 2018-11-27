
import java.util.ArrayList;
import java.util.Random;

public class Lottorivi {

    private ArrayList<Integer> numerot;

    public Lottorivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        return this.numerot;
    }

    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        Random r = new Random();
        // Kirjoita numeroiden arvonta tänne käyttämällä metodia sisaltaaNumeron()
        int i = 0;
        while (i < 7) {            
            int numero = r.nextInt(40) + 1;
            if (!sisaltaaNumeron(numero)) {
                this.numerot.add(numero);
                i++;
            }
        }
    }

    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa
        return this.numerot.contains(numero);
    }
}
