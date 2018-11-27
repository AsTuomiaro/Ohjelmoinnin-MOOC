
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
public class Palauteanalyytikko {
    private ArrayList<Palaute> palautteet;
    
    public Palauteanalyytikko() {
        this.palautteet = new ArrayList<>();
    }
    
    public void add(Palaute p) {
        this.palautteet.add(p);
    }
    
    public double palautteidenKeskiarvo() {
        int summa = 0;
        if (palautteet.isEmpty()) {
            return -1;
        }
        for (Palaute p : palautteet) {
            summa += p.getArvosana();
        }
        return 1.0 * summa / this.palautteet.size();
    }
    
    public ArrayList<Palaute> palautteetValilta(int alku, int loppu) {
        ArrayList<Palaute> palautettava = new ArrayList<>();
        for (Palaute p : palautteet) {
            if (p.getArvosana() >= alku && p.getArvosana() <= loppu) {
                palautettava.add(p);
            }
        }
        return palautettava;
    }

    @Override
    public String toString() {
        String listaus = "Palautteet: \n";
        for (Palaute p : palautteet) {
            listaus += "* " + p + "\n";
        }
        return listaus;
    }
}
