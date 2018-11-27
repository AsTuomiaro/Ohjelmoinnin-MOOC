/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukunimet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author asko
 */
public class Perhe {
    private ArrayList<Henkilo> jasenet;
    
    public Perhe() {
        this.jasenet = new ArrayList<>();
    }
    
    public void lisaa(Henkilo uusiHenkilo) {
        this.jasenet.add(uusiHenkilo);
    }
    
    public void poista(Henkilo henkilo) {
        this.jasenet.remove(henkilo);
    }

    @Override
    public String toString() {
        String palautettava = "";
        
        if (this.jasenet.isEmpty()) {
            return palautettava;
        }
        
        palautettava = this.jasenet.get(0).toString();
        for (int i = 1; i < this.jasenet.size(); i++) {
            palautettava += "\n" + this.jasenet.get(i).toString();
        }
        return palautettava;
    }
}
