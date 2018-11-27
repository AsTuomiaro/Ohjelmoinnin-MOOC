
import java.util.HashMap;
import java.util.Random;

public class Satunnaiskavely {

    private HashMap<Integer, HashMap<Integer, Double>> taulukko;
    private Random random;
    private int sijaintiX = 0;
    private int sijaintiY = 0;

    public Satunnaiskavely(int leveys, int korkeus) {
        this.taulukko = new HashMap<>();
        this.random = new Random();
        
        int x = 0;
        while (x < leveys) {
            this.taulukko.putIfAbsent(x, new HashMap<>());

            int y = 0;
            while (y < korkeus) {
                this.taulukko.get(x).put(y, 0.0);
                y++;
            }
            
            x++;
        }

        this.sijaintiX = leveys / 2;
        this.sijaintiY = korkeus / 2;

        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);
    }

    public void askel() {
        // pienennetään hajujalkeä
        int x = 0;
        while (x < this.taulukko.size()) {
            int y = 0;
            
            while (y < this.taulukko.get(x).size()) {

                double arvo = this.taulukko.get(x).get(y);
                if (arvo > 0) {
                    arvo -= 0.01;
                }

                this.taulukko.get(x).put(y, arvo);
                y++;
            }
            
            x++;
        }

        // Asetetaan tänne pisteen satunnaisliike
        double arpa = this.random.nextDouble();
        if (arpa > 0.8) {
            this.sijaintiX++;
        } else if (arpa > 0.6) {
            this.sijaintiY++;
        } else if (arpa > 0.4) {
            this.sijaintiX--;
        } else if (arpa > 0.2) {
            this.sijaintiY--;
        }

        // kun hahmo on tietyssä pisteessä, asetetaan taulukkoon arvo 1
        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);

    }

    public HashMap<Integer, HashMap<Integer, Double>> getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(HashMap<Integer, HashMap<Integer, Double>> taulukko) {
        this.taulukko = taulukko;
    }
}
