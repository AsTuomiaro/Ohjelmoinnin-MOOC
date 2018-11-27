/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asko
 */
public class Keskiarvosensori implements Sensori {
    private ArrayList<Sensori> sensorit;
    private List<Integer> mittaukset;
    
    public Keskiarvosensori() {
        this.sensorit = new ArrayList<>();
        this.mittaukset = new ArrayList<>();
    }
    
    public void lisaaSensori(Sensori uusiSensori) {
        this.sensorit.add(uusiSensori);
    }

    public List<Integer> mittaukset() {
        return mittaukset;
    }
    
    @Override
    public boolean onPaalla() {
        boolean onPaalla = true;
        for (Sensori s : this.sensorit) {
            if (!s.onPaalla()) {
                onPaalla = false;
            }
        }
        return onPaalla;
    }

    @Override
    public void paalle() {
        for (Sensori s : this.sensorit) {
            s.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        if (!this.sensorit.isEmpty()) {
            this.sensorit.get(0).poisPaalta();
        }
    }

    @Override
    public int mittaa() {
        if (this.sensorit.isEmpty() || !onPaalla()) {
            throw new IllegalStateException();
        }
        int summa = 0;
        for (Sensori s : this.sensorit) {
            summa += s.mittaa();
        }
        
        int tulos =  summa / this.sensorit.size();
        this.mittaukset.add(tulos);
        
        return tulos;
    }
    
}
