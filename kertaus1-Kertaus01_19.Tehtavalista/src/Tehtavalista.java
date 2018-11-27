
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Tehtavalista {
    private ArrayList<Tehtava> tehtavat;
    
    public Tehtavalista() {
        this.tehtavat = new ArrayList<>();
    }
    
    public void lisaa(String nimi) {
        this.tehtavat.add(new Tehtava(nimi));
    }
    
    public void asetaTehdyksi(String nimi) {
        Tehtava t = annaTehtava(nimi);
        t.asetaTehdyksi();
    }
    
    public void asetaTekemattomaksi(String nimi) {
        Tehtava t = annaTehtava(nimi);
        t.asetaTekemattomaksi();
    }
    
    public Tehtava annaTehtava(String nimi) {
        Tehtava palautettava = null;
        for (Tehtava t : tehtavat) {
            if (t.getNimi().equals(nimi)) {
                palautettava = t;
            }
        }
        return palautettava;
    }

    @Override
    public String toString() {
        String palautettava = "Tehtävät: \n";
        for (Tehtava t : tehtavat) {
            palautettava += "* " + t + "\n";
        }
        return palautettava;
    }
}
