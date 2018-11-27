/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

import java.util.ArrayList;

/**
 *
 * @author asko
 */
public class Lauma implements Siirrettava {
    private ArrayList<Siirrettava> siirrettavat;
    
    public Lauma() {
        this.siirrettavat = new ArrayList<>();
    }
    
    public void lisaaLaumaan(Siirrettava siirrettava) {
        this.siirrettavat.add(siirrettava);
    }
    
    @Override
    public void siirra(int dx, int dy) {
        for (Siirrettava s : this.siirrettavat) {
            s.siirra(dx, dy);
        }
    }

    @Override
    public String toString() {
        String palautettava = "";
        if (this.siirrettavat.isEmpty()) {
            return palautettava;
        }
        palautettava = this.siirrettavat.get(0).toString();
        for (int i = 1; i < this.siirrettavat.size(); i++) {
            palautettava += "\n" + this.siirrettavat.get(i).toString();
        }
        return palautettava;
    }
}
