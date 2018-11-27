
public class Main {

    public static void main(String[] args) {
        // voit tehdä tänne testikoodia

        // Jos ohjelmassa on useampi luokka, joka sisältää main-metodin, voi
        // halutun main metodin käynnistää valitsemalla luokka vasemmalla
        // olevasta projektilistauksesta ja painamalla oikealla
        // hiirennapilla "Run File".
        
        GameOfLife peli = new GameOfLife(4, 4);
        Taulukko taulukko = new Taulukko(4, 4);
        peli.setTaulukko(taulukko);
        peli.alustaSatunnaisesti();
        
        for (int i = 0; i < taulukko.getLeveys(); i++) {
            for (int j = 0; j < taulukko.getKorkeus(); j++) {
                System.out.println("(" + i + "," + j +") : " 
                        + taulukko.hae(i, j) + "; elossa olevien määrä: " 
                        + peli.elossaOleviaNaapureita(taulukko, i, j));
            }
        }
        
    }

}
