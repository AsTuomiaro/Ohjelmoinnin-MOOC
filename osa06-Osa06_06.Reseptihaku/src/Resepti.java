
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
public class Resepti {
    private String nimi;
    private int keittoaika;
    private ArrayList<String> ainekset;
    
    public Resepti(String nimi, int keittoaika) {
        this.nimi = nimi;
        this.keittoaika = keittoaika;
        this.ainekset = new ArrayList<>();
    }
    
    public void lisaaAines(String uusiAines) {
        this.ainekset.add(uusiAines);
    }
    
    public boolean haeAines(String haettava) {
        return ainekset.contains(haettava);
    }

    @Override
    public String toString() {
        return this.nimi + ", keittoaika: " + this.keittoaika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getKeittoaika() {
        return keittoaika;
    }
}
