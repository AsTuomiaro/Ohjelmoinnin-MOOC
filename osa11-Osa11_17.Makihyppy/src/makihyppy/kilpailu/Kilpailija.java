/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.kilpailu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asko
 */
public class Kilpailija {
    private String nimi;
    private int pisteet;
    private List<Integer> pituudet;
    
    public Kilpailija(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.pituudet = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getPituudet() {
        String palautettava = "";
        for (int i = 0; i < this.pituudet.size() - 1; i++) {
            palautettava += this.pituudet.get(i) + " m, ";
        }
        palautettava += this.pituudet.get(this.pituudet.size() - 1) + " m";
        return palautettava;
    }
    
    public void lisaaPituus(int uusiPituus) {
        this.pituudet.add(uusiPituus);
    }
    
    public void lisaaPisteita(int lisapisteet) {
        this.pisteet += lisapisteet;
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.pisteet + " pistettä)";
    }
}
