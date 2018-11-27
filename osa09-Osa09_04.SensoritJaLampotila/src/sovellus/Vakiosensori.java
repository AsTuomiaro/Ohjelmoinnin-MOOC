/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author asko
 */
public class Vakiosensori implements Sensori {
    private int tulos;
    
    public Vakiosensori(int tulos) {
        this.tulos = tulos;
    }
    
    @Override
    public boolean onPaalla() {
        return true;
    }

    @Override
    public void poisPaalta() {
    
    }

    @Override
    public int mittaa() {
        return this.tulos;
    }

    @Override
    public void paalle() {
    
    }
    
}
